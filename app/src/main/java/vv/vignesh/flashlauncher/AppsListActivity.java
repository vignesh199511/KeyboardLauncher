package vv.vignesh.flashlauncher;

import android.app.LauncherActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class AppsListActivity extends AppCompatActivity {

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_info_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.item1:
                // your first action code
                try {
                    //Open the specific App Info page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.parse("package:" + apps.get(info.position).label.toString()));
                    startActivity(intent);

                } catch ( ActivityNotFoundException e ) {
                    //e.printStackTrace();

                    //Open the generic Apps page:
                    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                    startActivity(intent);

                }
                return true;
            case R.id.item2:
                // your second action code
                Intent intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, Uri.parse("package:" + apps.get(info.position).label.toString()));
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    private void loadApps(){
        manager = getPackageManager();
        apps = new ArrayList<>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i,0);
        for (ResolveInfo ri : availableActivities){
            Item app = new Item();
            app.label = ri.activityInfo.packageName;
            app.name = ri.loadLabel(manager);
            app.icon = ri.loadIcon(manager);
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
                    convertView = getLayoutInflater().inflate(R.layout.item, null);
                }
                ImageView appIcon = convertView.findViewById(R.id.icon);
                appIcon.setImageDrawable(apps.get(position).icon);

                TextView appName = convertView.findViewById(R.id.name);
                appName.setText(apps.get(position).name);


                return convertView;
            }
        };

        list.setAdapter(adapter);
    }

    private void addClickListener(){
        registerForContextMenu(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                SharedPreferences preferences = getApplicationContext().getSharedPreferences("PROJECT_NAME", android.content.Context.MODE_PRIVATE);
                boolean isSelected = preferences.getBoolean(apps.get(position).name.toString(), false);
                if(isSelected) {
                    Intent myIntent = new Intent(AppsListActivity.this, FingerPrintLock.class);
                    myIntent.putExtra("key", apps.get(position).label.toString()); //Optional parameters
                    AppsListActivity.this.startActivity(myIntent);

                }
                else {
                    Intent i = manager.getLaunchIntentForPackage(apps.get(position).label.toString());
                    startActivity(i);
                    finish();
                }
            }
        });
    }

}
