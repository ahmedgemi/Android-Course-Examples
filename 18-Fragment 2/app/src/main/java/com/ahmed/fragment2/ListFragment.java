package com.ahmed.fragment2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListFragment extends Fragment implements OnAddListener{

    View view;

    ListView listView;
    ArrayAdapter<String> adapter;

    ArrayList<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null){

            view = inflater.inflate(R.layout.fragment_list,container,false);
            listView = view.findViewById(R.id.listView);
            adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list);
            listView.setAdapter(adapter);
        }

        return view;
    }

    @Override
    public void onAdd(String data) {

        list.add(data);
        adapter.notifyDataSetChanged();
    }
}
