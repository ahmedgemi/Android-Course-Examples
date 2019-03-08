package com.ahmed.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("APP","CREATE");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("APP","START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("APP","RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("APP","PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("APP","STOP");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("APP","RESTART");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("APP","DESTROY");
    }
}
