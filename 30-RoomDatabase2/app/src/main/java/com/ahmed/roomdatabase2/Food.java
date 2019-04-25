package com.ahmed.roomdatabase2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Food {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public double price;

    @ColumnInfo(name = "url")
    public String image;

    public Food(String name, double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Food(){

    }
}
