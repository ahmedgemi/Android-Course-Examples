package com.ahmed.roomdatabase2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Food.class,Order.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract DatabaseDao getDao();


    private static MyDatabase database;

    public synchronized static MyDatabase getInstance(Context context){

        if(database == null){
            database = Room.databaseBuilder(context,MyDatabase.class,"app.db")
                    .allowMainThreadQueries()
                    .build();
        }

        return database;
    }
}
