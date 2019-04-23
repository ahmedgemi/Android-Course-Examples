package com.ahmed.roomdatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    EditText editText_name,editText_salary;
    ListView listView;

    MyDatabase database;

    List<Employee> list = new ArrayList<>();
    ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(this,MyDatabase.class,"app.DB")
                .allowMainThreadQueries()
                .build();

        list = database.getDao().getAll();

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);

        editText_name = findViewById(R.id.editText);
        editText_salary = findViewById(R.id.editText2);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Employee employee = list.get(position);
                database.getDao().deleteEmployee(employee);

                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.clear();
                list.addAll(database.getDao().filterBySalary(5000));
                adapter.notifyDataSetChanged();
            }
        });
    }


    private void addEmployee(){

        String name = editText_name.getText().toString();
        String salary= editText_salary.getText().toString();

        Employee employee = new Employee();
        employee.name = name;
        employee.salary = Integer.valueOf(salary);

        list.add(employee);
        adapter.notifyDataSetChanged();

        database.getDao().addEmployee(employee);
    }
}
