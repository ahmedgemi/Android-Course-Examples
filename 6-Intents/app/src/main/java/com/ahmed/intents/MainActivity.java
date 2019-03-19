package com.ahmed.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String search = editText.getText().toString();
        String link = "http://google.com/#q=" + search;

        String number = "tel:+2011112222";

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(number));

        startActivity(intent);
    }
}
