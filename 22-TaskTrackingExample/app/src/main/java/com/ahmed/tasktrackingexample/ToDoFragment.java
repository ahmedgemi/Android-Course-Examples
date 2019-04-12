package com.ahmed.tasktrackingexample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoFragment extends Fragment implements ItemClickListener{

    View view;
    ArrayList<Task> list = new ArrayList<>();
    TaskListAdadpter adadpter;

    RecyclerView recyclerView;
    FloatingActionButton fab_add;

    TaskListener taskListener;

    public void setListener(TaskListener listener){
        this.taskListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_todo,container,false);

        adadpter = new TaskListAdadpter(getActivity(),list,this);

        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adadpter);

        fab_add = view.findViewById(R.id.fab_add);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }
        });

        return view;
    }

    void showDialog(){

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_task);

        final EditText editText = dialog.findViewById(R.id.editText);
        Button button = dialog.findViewById(R.id.button_add);
        final RadioButton radio1 = dialog.findViewById(R.id.radioButton);
        final RadioButton radio2 = dialog.findViewById(R.id.radioButton2);
        RadioButton radio3 = dialog.findViewById(R.id.radioButton3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = editText.getText().toString();
                if (title.isEmpty()){
                    editText.setError("Enter title");
                    return;
                }

                Type type;

                if(radio1.isChecked())
                    type = Type.LOW;
                else if (radio2.isChecked())
                    type = Type.NORMAL;
                else
                    type = Type.HIGH;

                list.add(0,new Task(title,type));
                adadpter.notifyItemInserted(0);

                dialog.dismiss();
            }
        });

        dialog.show();
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
