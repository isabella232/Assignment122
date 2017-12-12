package com.niketgoel.assignment122;

/**
 * Created by niketgoel on 12/12/17.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.niketgoel.assignment122.MainActivity.AGE;
import static com.niketgoel.assignment122.MainActivity.NAME;
import static com.niketgoel.assignment122.MainActivity.PHONE;

public class DisplayActivity extends AppCompatActivity {
    public static String name;
    public static String phone;
    public static String age;
    public static TextView nameText;
    public static TextView phoneText;
    public static TextView ageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        String name = intent.getStringExtra("nameKey");
        String phone = intent.getStringExtra("phoneKey");
        String age = intent.getStringExtra("ageKey");
        // Assigning reference to the views

        nameText = (TextView)findViewById(R.id.nameText);
        phoneText = (TextView)findViewById(R.id.phoneText);
        ageText = (TextView)findViewById(R.id.ageText);
        getDefaults(this);

        //Log.d("name :"+prefName,"show");

    }
// public static method to retrieve the preferences data from other activity

    /**
     *
     * @param context
     */
    public static void getDefaults( Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String prefName = preferences.getString(NAME, null);
        String prefPhone = preferences.getString(PHONE, null);
        String prefAge =  preferences.getString(AGE, null);
        nameText.setText(prefName);
        phoneText.setText(prefPhone);
        ageText.setText(prefAge);
    }

}
