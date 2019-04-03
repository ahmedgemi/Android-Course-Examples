package com.ahmed.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout myContainer;
    FragmentManager manager;
    FragmentTransaction fragmentTrans;

    Button button,button2;
    Fragment1 fragment1 = new Fragment1();
    Fragment2 fragment2 = new Fragment2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContainer =findViewById(R.id.myContainer);

        manager = getSupportFragmentManager();
        fragmentTrans = manager.beginTransaction();

        fragmentTrans.replace(R.id.myContainer, fragment1);
        fragmentTrans.commit();

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    public void setDataToFrag1(String s){
        fragment1.setData(s);

        button.performClick();
    }

    @Override
    public void onClick(View v) {

        fragmentTrans = manager.beginTransaction();

        switch (v.getId()){

            case  R.id.button:
                fragmentTrans.replace(R.id.myContainer, fragment1);
                fragmentTrans.addToBackStack(null);
                fragmentTrans.commit();
                break;

            case R.id.button2:
                fragmentTrans.replace(R.id.myContainer, fragment2);
                fragmentTrans.addToBackStack(null);
                fragmentTrans.commit();
                break;
        }
    }
}
