package com.ahmed.listview;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Student> list = new ArrayList<>();
    ArrayAdapter<Student> adapter;

    ListView listView;
    EditText editText,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(
                this,
                R.layout.list_item,
                list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                String str = list.get(position);
//
//                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                list.remove(position);
                adapter.notifyDataSetChanged();

                return true;
            }
        });

         editText = findViewById(R.id.editText);
        editText2 =findViewById(R.id.editText2);
         button = findViewById(R.id.button);
         button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = editText.getText().toString();
        String grade = editText2.getText().toString();

        list.add(new Student(name,Integer.valueOf(grade)));

        adapter.notifyDataSetChanged();
    }
}
