package com.ahmed.listview2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    ArrayList<Student> list;

    public StudentAdapter(ArrayList<Student> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());

        View view = layoutInf.inflate(R.layout.item_student,parent,false);

        Student student = list.get(position);

        TextView textView_name = view.findViewById(R.id.textView_name);
        textView_name.setText(student.getName());

        TextView textView_grade = view.findViewById(R.id.textView_grade);
        textView_grade.setText(String.valueOf(student.getGrade()));

        TextView textView_class = view.findViewById(R.id.textView_class);
        textView_class.setText(student.getClassName());
                ;
        return view;
    }
}
