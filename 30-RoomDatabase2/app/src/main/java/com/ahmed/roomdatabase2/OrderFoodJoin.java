package com.ahmed.roomdatabase2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class OrderFoodJoin {

    public int id;

    public String name;

    public double price;

    public int quantity;

    @ColumnInfo(name = "url")
    public String image;


}
