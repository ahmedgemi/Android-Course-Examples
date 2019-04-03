package com.ahmed.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragment2 extends Fragment implements View.OnClickListener {

    View view;

    Button button;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment2_layout,container,false);

        editText = view.findViewById(R.id.editText);

        button = view.findViewById(R.id.button3);
        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        String str = editText.getText().toString();

        MainActivity activity = (MainActivity) getActivity();

        activity.setDataToFrag1(str);

    }
}
