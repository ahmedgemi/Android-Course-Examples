package com.ahmed.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> list = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Student("Amr","3/3",70));
        list.add(new Student("Eslam","1/3",50));
        list.add(new Student("Kamal","2/3",80));
        list.add(new Student("Ahmed","3/4",40));
        list.add(new Student("Omar","4/3",70));
        list.add(new Student("Amr","3/5",90));
        list.add(new Student("Amr","3/3",70));
        list.add(new Student("Eslam","1/3",50));
        list.add(new Student("Kamal","2/3",80));
        list.add(new Student("Ahmed","3/4",40));
        list.add(new Student("Omar","4/3",70));
        list.add(new Student("Amr","3/5",90));

        listView = findViewById(R.id.listView);

        StudentAdapter adapter = new StudentAdapter(list);

        listView.setAdapter(adapter);

    }
}
