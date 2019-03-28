package com.ahmed.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_name,editText_grade;
    private Button button_add,button_avg;
    private TextView textView;

    private ArrayList<Student> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_grade = findViewById(R.id.editText_grade);
        editText_name = findViewById(R.id.editText_name);
        textView = findViewById(R.id.textView);

        button_add = findViewById(R.id.button_add);
        button_add.setOnClickListener(this);

        button_avg = findViewById(R.id.button_avg);
        button_avg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_add:
                addStudent();
                break;

            case R.id.button_avg:
                calculateAVG();
                break;
        }
    }

    private void calculateAVG(){
        if (list.size()==0){
            Toast.makeText(this,"No Student",Toast.LENGTH_SHORT).show();
            return;
        }

        int sum =0;
        for (Student s : list){
            sum += s.getGrade();
        }

        double result = (double) sum/list.size();

        textView.setText(String.valueOf(result));
    }

    private void addStudent(){
        String name = editText_name.getText().toString();
        String g = editText_grade.getText().toString();

        if (name.isEmpty() || g.isEmpty()){
            Toast.makeText(this,"Please Fill All Data",Toast.LENGTH_SHORT).show();
            return;
        }

        Student s = new Student(name, Integer.valueOf(g));
        list.add(s);

        Toast.makeText(this,"Student Added",Toast.LENGTH_SHORT).show();
        editText_name.setText("");
        editText_grade.setText("");
    }
}
