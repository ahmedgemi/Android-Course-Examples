package com.ahmed.roomdatabase2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderFragment extends Fragment {

    View view;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    FoodListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_order,container,false);

        ButterKnife.bind(this,view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        getOrders();

        return view;
    }

    private void getOrders(){


        List<OrderFoodJoin> list = MyDatabase.getInstance(getActivity()).getDao().getOrders();

        adapter = new FoodListAdapter(getActivity(),list,true);
        recyclerView.setAdapter(adapter);
    }

}
