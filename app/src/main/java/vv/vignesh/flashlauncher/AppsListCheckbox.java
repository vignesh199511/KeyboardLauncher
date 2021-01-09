package vv.vignesh.flashlauncher;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vignesh on 10-03-2018.
 */

public class AppsListCheckbox extends AppCompatActivity  {

    private PackageManager manager;
    private List<Item> apps;
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_list);

        loadApps();
        loadListView();
        addClickListener();
        LayoutAnimationController controller
                = AnimationUtils.loadLayoutAnimation(
                this, R.anim.list_layout_controller);
        list.setLayoutAnimation(controller);

    }

    private void loadApps(){
        manager = getPackageManager();
        apps = new ArrayList<>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i,0);
        for (ResolveInfo ri : availableActivities){


            Item app = new Item();
            app.label = ri.activityInfo.packageName;
            app.name = ri.loadLabel(manager);
            app.icon = ri.loadIcon(manager);
            boolean isSelected = preferences.getBoolean(app.name.toString(), false);
            app.appLock = isSelected;
            apps.add(app);

        }
        Collections.sort(apps, new Comparator<Item>() {
            @Override
            public int compare(Item t1, Item t2) {
                CharSequence a = t1.name;
                CharSequence b = t2.name;
                int c = a.toString().toLowerCase() .compareTo(b.toString().toLowerCase());
                return c;
            }
        });

    }


    private void loadListView() {
        list = findViewById(R.id.list);

        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this, R.layout.item, apps){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.itemcheckbox, null);
                }
                ImageView appIcon = convertView.findViewById(R.id.icon);
                appIcon.setImageDrawable(apps.get(position).icon);

                TextView appName = convertView.findViewById(R.id.name);
                appName.setText(apps.get(position).name);
                final String appnamekey= apps.get(position).name.toString();

                CheckBox appLockCheckbox = convertView.findViewById(R.id.applock);
                appLockCheckbox.setChecked(apps.get(position).appLock);
                final Boolean appLockCheckboxValue = apps.get(position).appLock;


                appLockCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        // perform necessary action when check event happens
                        SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();

                            editor.putBoolean(appnamekey, !appLockCheckboxValue);
                            editor.commit();
                    }
                });


                return convertView;
            }
        };

        list.setAdapter(adapter);
    }

    private void addClickListener(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = manager.getLaunchIntentForPackage(apps.get(position).label.toString());
                startActivity(i);
                finish();
            }
        });
    }

}
