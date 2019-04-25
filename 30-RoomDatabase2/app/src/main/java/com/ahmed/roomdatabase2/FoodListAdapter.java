package com.ahmed.roomdatabase2;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ItemHolder>{

    private Context context;
    private List<Food> list;
    private List<OrderFoodJoin> joinList;
    private boolean flag = false;

    public FoodListAdapter(Context context, List<Food> list) {
        this.context = context;
        this.list = list;
    }

    public FoodListAdapter(Context context, List<OrderFoodJoin> list,boolean flag) {
        this.context = context;
        this.joinList = list;
        this.flag = flag;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        if(flag){
            OrderFoodJoin obj = joinList.get(position);
            holder.setData(obj);
        }
        else{
            Food food = list.get(position);
            holder.setData(food);
        }
    }

    @Override
    public int getItemCount() {
        if(flag)
            return joinList.size();
        return list.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.textView_name)
        TextView textView_name;
        @BindView(R.id.textView_price)
        TextView textView_price;
        @BindView(R.id.cardView)
        CardView cardView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }

        public void setData(Food food){
            textView_name.setText(food.name);
            textView_price.setText(String.valueOf(food.price));

            Glide.with(context).load(food.image).into(imageView);

            cardView.setOnClickListener(view->{

                int quantity = new Random().nextInt(10) +1;
                Order order = new Order(quantity,food.id);

                MyDatabase.getInstance(context).getDao().addOrder(order);

                Toast.makeText(context,"Order Added",Toast.LENGTH_SHORT).show();
            });
        }

        public void setData(OrderFoodJoin obj){

            textView_name.setText(obj.name);
            textView_price.setText(String.valueOf(obj.quantity) + " - "+String.valueOf(obj.price * obj.quantity));

            Glide.with(context).load(obj.image).into(imageView);

        }

    }
}
