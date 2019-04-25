package com.ahmed.roomdatabase2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FoodFragment extends Fragment {

    View view;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    FoodListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_food,container,false);

        ButterKnife.bind(this,view);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        getFood();

        return view;
    }

    private void getFood(){


        List<Food> list = MyDatabase.getInstance(getActivity()).getDao().getFood();

        adapter = new FoodListAdapter(getActivity(),list);
        recyclerView.setAdapter(adapter);
    }

    @OnClick({R.id.fab_add})
    public void addFood(){
        AddDialog dialog = new AddDialog(getActivity());
        dialog.show();
    }
}




























