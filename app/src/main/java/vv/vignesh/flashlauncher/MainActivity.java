package vv.vignesh.flashlauncher;

import android.app.WallpaperManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.widget.AdapterView;

import java.io.IOException;
import java.lang.reflect.Field;


public class MainActivity extends AppCompatActivity {
    public static String letter;
    private static final String TAG = "MainActivity";

    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //detector = new GestureDetector(this);


        setContentView(R.layout.activity_main);

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,new MyGestureListener());
        // Set the gesture detector as the double tap
        // listener.


        Button button = findViewById(R.id.button);

//        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
//        Drawable wallpaperDrawable = wallpaperManager.getDrawable();
//        Bitmap bitmap1 = ((BitmapDrawable)wallpaperDrawable).getBitmap();
//        Palette.from(bitmap1).generate(new Palette.PaletteAsyncListener() {
//            public void onGenerated(Palette palette) {
//                int defaultValue = 0x000000;
//                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
//                int vibrantLight = palette.getLightVibrantColor(defaultValue);
//                if (vibrantDark != 0) {
//                    button.setTextColor(vibrantDark);
//                }
//                if (vibrantLight!=0){
//                    button.setBackgroundColor(vibrantLight);
//                }
//            }
//        });




        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AppsListActivity.class);
                startActivity(intent);

            }

        });


        Button lettterq = findViewById(R.id.letterq);
        lettterq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "q";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });
        lettterq.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                letter = "q";
                //Intent intent = new Intent(getApplicationContext(), ContactListActivity.class);
                //startActivity(intent);
                Toast.makeText(MainActivity.this, "long clicked", Toast.LENGTH_SHORT).show();

                return false;
            }

        });

        Button lettterw = findViewById(R.id.letterw);
        lettterw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "w";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button letttere = findViewById(R.id.lettere);
        letttere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "e";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterr = findViewById(R.id.letterr);
        lettterr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "r";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button letttert = findViewById(R.id.lettert);
        letttert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "t";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button letttery = findViewById(R.id.lettery);
        letttery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "y";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettteru = findViewById(R.id.letteru);
        lettteru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "u";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettteri = findViewById(R.id.letteri);
        lettteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "i";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button letttero = findViewById(R.id.lettero);
        letttero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "o";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterp = findViewById(R.id.letterp);
        lettterp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "p";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button letttera = findViewById(R.id.lettera);
        letttera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "a";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettters = findViewById(R.id.letters);
        lettters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "s";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterd = findViewById(R.id.letterd);
        lettterd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "d";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterf = findViewById(R.id.letterf);
        lettterf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "f";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterg = findViewById(R.id.letterg);
        lettterg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "g";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterh = findViewById(R.id.letterh);
        lettterh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "h";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterj = findViewById(R.id.letterj);
        lettterj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "j";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterk = findViewById(R.id.letterk);
        lettterk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "k";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterl = findViewById(R.id.letterl);
        lettterl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "l";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterz = findViewById(R.id.letterz);
        lettterz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "z";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterx = findViewById(R.id.letterx);
        lettterx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "x";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterc = findViewById(R.id.letterc);
        lettterc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "c";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterv = findViewById(R.id.letterv);
        lettterv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "v";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterb = findViewById(R.id.letterb);
        lettterb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "b";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button letttern = findViewById(R.id.lettern);
        letttern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "n";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button lettterm = findViewById(R.id.letterm);
        lettterm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "m";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number1 = findViewById(R.id.number1);
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "1";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number2 = findViewById(R.id.number2);
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "2";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number3 = findViewById(R.id.number3);
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "3";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number4 = findViewById(R.id.number4);
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "4";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number5 = findViewById(R.id.number5);
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "5";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number6 = findViewById(R.id.number6);
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "6";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number7 = findViewById(R.id.number7);
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "7";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number8 = findViewById(R.id.number8);
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "8";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number9 = findViewById(R.id.number9);
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "9";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        Button number0 = findViewById(R.id.number0);
        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letter = "1";
                Intent intent = new Intent(getApplicationContext(), AppsListActivityFiltered.class);
                startActivity(intent);
            }
        });

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        Boolean switchPref = sharedPref.getBoolean
                (SettingsActivity.KEY_PREF_EXAMPLE_SWITCH, false);
        if(switchPref){
            number1.setVisibility(View.GONE);
            number2.setVisibility(View.GONE);
            number3.setVisibility(View.GONE);
            number4.setVisibility(View.GONE);
            number5.setVisibility(View.GONE);
            number6.setVisibility(View.GONE);
            number7.setVisibility(View.GONE);
            number8.setVisibility(View.GONE);
            number9.setVisibility(View.GONE);
            number0.setVisibility(View.GONE);
        }
        else {
            number1.setVisibility(View.VISIBLE);
            number2.setVisibility(View.VISIBLE);
            number3.setVisibility(View.VISIBLE);
            number4.setVisibility(View.VISIBLE);
            number5.setVisibility(View.VISIBLE);
            number6.setVisibility(View.VISIBLE);
            number7.setVisibility(View.VISIBLE);
            number8.setVisibility(View.VISIBLE);
            number9.setVisibility(View.VISIBLE);
            number0.setVisibility(View.VISIBLE);

        }

        //Button button = findViewById(R.id.button); This is to open menu on long press
        registerForContextMenu(button);


        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);


    }

    private Palette createPaletteSync(Bitmap bitmap) {
        Palette p = Palette.from(bitmap).generate();
        return p;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.flash_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                // your first action code
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                // your second action code
                setWallPaper();
                return true;
            case R.id.item3:
                // your second action code
                Intent intent2 = new Intent(this, AboutAppActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        //do nothing
        //super.onBackPressed();
    }

    @Override
    public void onResume() {
        Button button = findViewById(R.id.button);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Drawable wallpaperDrawable = wallpaperManager.getDrawable();
        Bitmap bitmap1 = ((BitmapDrawable)wallpaperDrawable).getBitmap();

        Palette p = createPaletteSync(bitmap1);
        Palette.Swatch vibrantSwatch = p.getVibrantSwatch();
        if(vibrantSwatch != null){
            button.setTextColor(vibrantSwatch.getRgb());
            button.setBackgroundColor(vibrantSwatch.getTitleTextColor());
        }

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {

            System.out.println(alphabet);
            Field field = null;
            int screenid = 0;
            try {
                field = R.id.class.getField("letter" + alphabet);
                try {
                    screenid = field.getInt(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Button buttona2z = findViewById(screenid);
            if(vibrantSwatch != null){
                buttona2z.setTextColor(vibrantSwatch.getRgb());
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setStroke(5, vibrantSwatch.getRgb());
                drawable.setColor(vibrantSwatch.getTitleTextColor());
                buttona2z.setBackground(drawable);
            }

        }
        for (int number = 0 ; number <= 9 ; number++) {

            Field field = null;
            int screenid = 0;
            try {
                field = R.id.class.getField("number" + number);
                try {
                    screenid = field.getInt(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Button button0to9 = findViewById(screenid);
            if(vibrantSwatch != null){
                button0to9.setTextColor(vibrantSwatch.getRgb());
                GradientDrawable drawable = new GradientDrawable();
                drawable.setShape(GradientDrawable.RECTANGLE);
                drawable.setStroke(5, vibrantSwatch.getRgb());
                drawable.setColor(vibrantSwatch.getTitleTextColor());
                button0to9.setBackground(drawable);
            }

        }

        super.onResume();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        this.mDetector.onTouchEvent(event);

                return super.onTouchEvent(event);

    }

    private void setWallPaper() {
        pickImageFromGallery();

    }

    public static final int IMAGEREQUESTCODE = 65535;
    Bitmap bitmap = null;

    private void pickImageFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, IMAGEREQUESTCODE);
        System.err.println("vignesh1");
    }

    @Override
    protected final void onActivityResult(final int requestCode,
                                          final int resultCode, final Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        System.err.println("vignesh2");
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case IMAGEREQUESTCODE:
                    System.err.println("vignesh3");
                    manageImageFromUri1(i.getData());
                    System.err.println("vignesh4");
                    break;
            }
        } else {
            // manage result not ok !
        }

    }

    private void manageImageFromUri1(Uri data) {
        System.err.println("vignesh5");
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Intent intent = new Intent(wallpaperManager.getCropAndSetWallpaperIntent(data));
        startActivity(intent);
        System.err.println("vignesh6");
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_MIN_DISTANCE = 150;
        private static final int SWIPE_THRESHOLD_VELOCITY = 100;

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(DEBUG_TAG, "onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
            if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                onRightToLeft();
                return true;
            }
            else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                onLeftToRight();
                return true;
            }

            if (event1.getY() - event2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                onBottomToTop();
                return true;
            }
            else if (event2.getY() - event1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                onTopToBottom();
                return true;
            }
            return true;
        }
    }


    public void onRightToLeft() { Log.d(DEBUG_TAG, "onRightToLeft:" ); }

    public void onLeftToRight() { Log.d(DEBUG_TAG, "onLeftToRight:"); }

    public void onBottomToTop() { Log.d(DEBUG_TAG, "onBottomToTop:");
        Intent intent = new Intent(getApplicationContext(), AppsListActivity.class);
        startActivity(intent);
    }

    public void onTopToBottom() { Log.d(DEBUG_TAG, "onTopToBottom:"); }

//    private void manageImageFromUri(Uri imageUri) {
//
//
//        try {
//            bitmap = MediaStore.Images.Media.getBitmap(
//                    this.getContentResolver(), imageUri);
//
//        } catch (Exception e) {
//            // Manage exception ...
//        }
//
//        if (bitmap != null) {
//            // Here you can use bitmap in your application ...
//            WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
//            try {
//                System.out.println("vignesh");
//                wallpaperManager.setBitmap(bitmap);
//
//                Toast toast = Toast.makeText(this, "Set wallpaper successfully!", Toast.LENGTH_LONG);
//                toast.show();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }




//    private void paintTextBackground() {
//
//        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
//        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();
//        Bitmap bitmap = ((BitmapDrawable)wallpaperDrawable).getBitmap();
//
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(Palette palette) {
//                //work with the palette here
//                int defaultValue = 0x000000;
//                int vibrant = palette.getVibrantColor(defaultValue);
//                int vibrantLight = palette.getLightVibrantColor(defaultValue);
//                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
//                int muted = palette.getMutedColor(defaultValue);
//                int mutedLight = palette.getLightMutedColor(defaultValue);
//                int mutedDark = palette.getDarkMutedColor(defaultValue);
//
////                vibrantView.setBackgroundColor(vibrant);
////                vibrantLightView.setBackgroundColor(vibrantLight);
////                vibrantDarkView.setBackgroundColor(vibrantDark);
////                mutedView.setBackgroundColor(muted);
////                mutedLightView.setBackgroundColor(mutedLight);
////                mutedDarkView.setBackgroundColor(mutedDark);
//                 // button.setTextColor(vibrantLight);
//
//            }
//        });
//
//
//    }
}
