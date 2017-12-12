package com.niketgoel.assignment122;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // Declaring variables to handle views.
    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText ageEditText;
    private Button button;
    // Declaring String constants to create key for preferences.
    public static final String MYPREFERENCES = "MyPrefs";
    public static final String NAME = "nameKey";
    public static final String PHONE = "phoneKey";
    public static final String AGE = "adeKey";

    // SharedPreferences object declaration
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning reference to the views
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        ageEditText = (EditText)findViewById(R.id.ageEditText);
        phoneEditText = (EditText)findViewById(R.id.phoneEditText);
        button = (Button)findViewById(R.id.showButton);
        sharedPreferences = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String age = ageEditText.getText().toString();

                setDefaults(name, phone, age, MainActivity.this);

                Intent i = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });
    }

    /**
     * To save the preferences data to the preferences file
     * @param name
     * @param phone
     * @param age
     * @param context
     */
    public static void setDefaults(String name, String phone, String age, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();


        editor.putString(NAME, name);
        editor.putString(PHONE, phone);
        editor.putString(AGE, age);
        editor.apply();

    }

}
