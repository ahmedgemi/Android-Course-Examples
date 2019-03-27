package com.ahmed.listviewstudent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Student> studentList = new ArrayList<>();
    StudentAdapter adapter;
    ListView listView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new StudentAdapter(this,studentList);

        listView = findViewById(R.id.listiew);
        listView.setAdapter(adapter);

        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent =new Intent(this,AddStudentActivity.class);
        startActivityForResult(intent,200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==200 && resultCode == RESULT_OK){

            Student student = (Student) data.getExtras().getSerializable("data");

            studentList.add(student);
            adapter.notifyDataSetChanged();
        }
    }
}
