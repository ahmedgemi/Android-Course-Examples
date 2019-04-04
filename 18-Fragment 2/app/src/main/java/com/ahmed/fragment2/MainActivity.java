package com.ahmed.fragment2;

import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;

    ListFragment listFragment = new ListFragment();
    AddFragment addFragment = new AddFragment();

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        addFragment.setListener(listFragment);

        aSwitch = findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                transaction = manager.beginTransaction();

                if(isChecked){
                    transaction.replace(R.id.container,listFragment);
                }
                else{
                    transaction.replace(R.id.container,addFragment);
                }

                transaction.commit();
            }
        });
    }
}
