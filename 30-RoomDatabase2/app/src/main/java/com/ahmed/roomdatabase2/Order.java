package com.ahmed.roomdatabase2;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "myOrder")
@ForeignKey(entity = Food.class,parentColumns = "id",childColumns = "food_id")
public class Order {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int quantity;

    public int food_id;

    public Order(int quantity, int food_id) {
        this.quantity = quantity;
        this.food_id = food_id;
    }

    public Order(){

    }
}
