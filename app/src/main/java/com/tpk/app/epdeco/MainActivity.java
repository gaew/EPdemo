package com.tpk.app.epdeco;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"ม่านตาไก่"};
    int Numboftabs =1;
    boolean check_firsttime = false ;
    public static final String PREFS_NAME = "MyPrefsFile";
    ViewPager pager;
    SQLiteDatabase mDb;

    public static boolean onstart;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titleMain);


        if(onstart==false){
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Supporter");
            alertDialog.setMessage("EP Decor (Thailand) Co.,Ltd       Address: Hwy Chiang Mai-Lampang Frontage Rd, Mueang Chiang Mai District, Chiang Mai 50300\n" +
                    "Phone:053 406 394");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            onstart = true;
        }

        MainActivity.MyDbHelper db = new MainActivity.MyDbHelper(this);
        mDb = db.getWritableDatabase();
        Cursor mCursor = mDb.rawQuery("SELECT " + MainActivity.MyDbHelper.CODE + " FROM "+  MainActivity.MyDbHelper.TABLE_NAME, null);

        Log.i("Data Count", String.valueOf(mCursor.getCount()));

        //test dialog

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        Button eyelet = (Button)findViewById(R.id.eyelet_bt);

        eyelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Eyelet.class));
            }
        });



    }

    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences save_first_time = getPreferences(0);
        SharedPreferences.Editor editor = save_first_time.edit();
        editor.putBoolean("first_time", true);

        // Commit the edits!
        editor.commit();
    }


    public void onBackPressed() {

    }


    public static   class MyDbHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "caldecorate";
        private static final int DB_VERSION = 1;
        public static final String TABLE_NAME = "fab";
        public static final String COMPANY = "company";
        public static final String TYPE = "type";
        public static final String CODE = "code";
        public static final String WIDTH = "width";
        public static final String PRICE = "price";
        public static final String IMAGE = "image";

        public MyDbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COMPANY + " TEXT, " + TYPE + " TEXT, "
                    + CODE + " TEXT, " + WIDTH + " TEXT, " + PRICE + " TEXT, " + IMAGE + " TEXT); ");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('Extra', 'ม่านตาไก่', 'EP001','64','445'," +
                    "'http://st.hzcdn.com/simgs/6aa1507c059574d4_9-9593/mediterranean-upholstery-fabric.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('U save', 'ม่านตาไก่', 'EP002','46','419'," +
                    "'http://www.arcadia-textiles.co.uk/userfiles/lg_images/Wild_Fern_Mineral_Curtain_Fabric-xAyno1.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('NEO extra', 'ม่านตาไก่', 'EP003','24','805'," +
                    "'https://d2d00szk9na1qq.cloudfront.net/Product/4211e281-1f6a-41b5-98f2-77004e929e35/Images/Large_0420649.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('NEO eyelet', 'ม่านตาไก่', 'EP004','93','630'," +
                    "'https://d2d00szk9na1qq.cloudfront.net/Product/c9eb56d6-da24-440c-892d-774cf7454cf3/Images/Large_UK-138.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('NEO eyelet', 'ม่านตาไก่', 'EP005','37','452'," +
                    "'https://d2d00szk9na1qq.cloudfront.net/Product/af22dcef-73f2-4655-b134-00b9f278eac1/Images/Large_0408385.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('NEO eyelet', 'ม่านตาไก่', 'EP006','91','348'," +
                    "'http://mayang.com/textures/Fabric/images/Patterned%20Fabric/rug_closeup_9280130.JPG');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('Extra', 'ม่านตาไก่', 'EP007','95','842'," +
                    "'http://mayang.com/textures/Fabric/images/Patterned%20Fabric/carpet_texture_071281.JPG');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +")" +
                    " VALUES ('Extra', 'ม่านตาไก่', 'EP008','38','864'," +
                    "'http://mayang.com/textures/Fabric/images/Patterned%20Fabric/silk_071322.JPG');");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }



}