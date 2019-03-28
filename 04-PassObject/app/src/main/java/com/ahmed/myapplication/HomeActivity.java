package com.ahmed.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();

        Student s = (Student) bundle.getSerializable("data");

        textView.setText(s.name + "-"+String.valueOf(s.grade));
    }
}
