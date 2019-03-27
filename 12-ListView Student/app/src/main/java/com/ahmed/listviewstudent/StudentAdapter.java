package com.ahmed.listviewstudent;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    Context context;
    ArrayList<Student> list;

    public StudentAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
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

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_student,parent,false);

        Student student = list.get(position);

        TextView textViewName = view.findViewById(R.id.textView_name);
        textViewName.setText(student.getName());

        TextView textViewGrade = view.findViewById(R.id.textView_grade);
        textViewGrade.setText(student.getGrade());

        if(student.getImage() !=null){

            ImageView imageView = view.findViewById(R.id.imageView);
            imageView.setImageURI(Uri.parse(student.getImage()));
        }

        return view;
    }
}
