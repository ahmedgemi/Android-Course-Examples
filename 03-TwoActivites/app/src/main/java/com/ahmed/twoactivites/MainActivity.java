package com.ahmed.twoactivites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText_username,editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_username = findViewById(R.id.editText);
        editText_password = findViewById(R.id.editText2);

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = editText_username.getText().toString();
                String pass = editText_password.getText().toString();

                if (user.equals("omar") && pass.equals("123")){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("name",user);
                    intent.putExtra("age",30);

                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this,"Wrong username or password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
