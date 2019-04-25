package com.ahmed.sharedprefrence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        SharedPreferences preferences = getSharedPreferences("app.pref", Context.MODE_PRIVATE);

       int x =  preferences.getInt("count",0);

        textView.setText(String.valueOf(x));

        SharedPreferences.Editor editor = preferences.edit();

        editor.putInt("count",x+1);
        editor.putString("key","Heloo");
        editor.putBoolean("flag",true);

        editor.apply();
    }
}
