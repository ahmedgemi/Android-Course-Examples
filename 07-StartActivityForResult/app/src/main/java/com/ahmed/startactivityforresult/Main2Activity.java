package com.ahmed.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = editText.getText().toString();

        if (name.isEmpty()){
            setResult(RESULT_CANCELED);
        }
        else {
            Intent intent = new Intent();
            intent.putExtra("data",name);

            setResult(RESULT_OK,intent);
        }

        finish();

    }
}
