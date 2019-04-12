package com.ahmed.tasktrackingexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ProgressFragment  extends Fragment implements TaskListener, ItemClickListener{

    View view;

    ArrayList<Task> list = new ArrayList<>();
    TaskListAdadpter adadpter;

    RecyclerView recyclerView;

    TaskListener taskListener;

    public void setListener(TaskListener listener){
        this.taskListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_progress, container, false);

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

        taskListener.onTaskAdded(task);

        int index = list.indexOf(task);
        list.remove(task);

        adadpter.notifyItemRemoved(index);
        Utils.showNotification(getActivity(),"Task Changed",task.getTitle());
    }
}
