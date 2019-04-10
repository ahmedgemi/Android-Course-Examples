package com.ahmed.tasktrackingexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListAdadpter extends RecyclerView.Adapter<TaskListAdadpter.TaskHolder> {

    private Context context;
    private ArrayList<Task> list;

    public TaskListAdadpter(Context context, ArrayList<Task> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_task,viewGroup,false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder taskHolder, int i) {

        Task task = list.get(i);

        taskHolder.bindData(task);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder{

        TextView textView,textView3;
        CardView cardView;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView2);
            textView3 =itemView.findViewById(R.id.textView3);
            cardView = itemView.findViewById(R.id.cardView);
        }

        void bindData(Task task){

            textView.setText(task.getTitle());
            textView3.setText(task.getType().toString());

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
