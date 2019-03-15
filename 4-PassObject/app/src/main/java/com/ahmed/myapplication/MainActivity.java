package com.ahmed.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText editText,editText2;

    int count =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user = editText.getText().toString();
        String pass = editText2.getText().toString();

        if(user.equals("a@a.com")&& pass.equals("abc")){

            Student s = new Student(1,"Amr",80);

            Bundle bundle = new Bundle();
            bundle.putSerializable("data",s);

            Intent intent = new Intent(this,HomeActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
        }
        else {
            count --;

            if(count<=0){
                finish();
            }
            else{
                Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
