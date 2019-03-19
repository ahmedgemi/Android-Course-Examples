package com.ahmed.startactivityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button,button2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        button = findViewById(R.id.button2);
        button.setOnClickListener(this);

        button2 = findViewById(R.id.button4);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button2){
            Intent intent = new Intent(this,Main2Activity.class);
            startActivityForResult(intent,100);
        }
        else if (v.getId() == R.id.button4){
            Intent intent = new Intent(this,Main3Activity.class);
            startActivityForResult(intent,200);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 100){

            if (resultCode == RESULT_OK){

                String s = data.getExtras().getString("data");
                textView.setText(s);
            }
            else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
            }
        }
        else if (requestCode == 200 && resultCode == 10){
            int z = data.getExtras().getInt("choice");
            textView.setText(String.valueOf(z));
        }

    }
}
