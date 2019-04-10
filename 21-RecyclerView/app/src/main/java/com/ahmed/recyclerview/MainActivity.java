package com.ahmed.recyclerview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListAdadpter adadpter;

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("Amr");
        list.add("Ali");
        list.add("Amr");
        list.add("Kamal");
        list.add("Amr");
        list.add("Osmana");
        list.add("Amr");
        list.add("Ahmed");
        list.add("Amr");
        list.add("Ali");
        list.add("Amr");
        list.add("Kamal");
        list.add("Amr");
        list.add("Osmana");
        list.add("Amr");
        list.add("Ahmed");;

        adadpter = new ListAdadpter(this,list);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        //GridLayoutManager manager = new GridLayoutManager(this,2);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adadpter);
    }

}
