package com.ahmed.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    RadioButton radio1,radio2,radio3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        radio1 = findViewById(R.id.radioButton);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);

        button = findViewById(R.id.button3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int x ;

        if (radio1.isChecked())
            x=1;
        else if (radio2.isChecked())
            x=2;
        else
            x=3;

        Intent intent = new Intent();
        intent.putExtra("choice",x);

        setResult(10,intent);
        finish();
    }
}
