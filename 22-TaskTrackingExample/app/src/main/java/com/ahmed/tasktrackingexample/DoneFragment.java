package com.ahmed.tasktrackingexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DoneFragment  extends Fragment implements TaskListener, ItemClickListener{

    View view;

    ArrayList<Task> list = new ArrayList<>();
    TaskListAdadpter adadpter;

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_done,container,false);

        adadpter = new TaskListAdadpter(getActivity(),list,this);

        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adadpter);

        return view;
    }

    @Override
    public void onTaskAdded(Task task) {

        list.add(0,task);
        adadpter.notifyItemInserted(0);
    }

    @Override
    public void onItemClick(Task task) {

        int index = list.indexOf(task);
        list.remove(task);

        adadpter.notifyItemRemoved(index);

        Utils.showNotification(getActivity(),"Task Changed",task.getTitle());
    }
}
