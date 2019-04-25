package com.ahmed.roomdatabase2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM food")
    List<Food> getFood();

    @Insert
    void addFood(Food food);

    @Insert
    void addOrder(Order order);


    @Update
    void updateFood(Food food);


    @Query("SELECT * FROM food INNER JOIN myOrder ON food.id = food_id")
    List<OrderFoodJoin> getOrders();
}


























