package com.ahmed.roomdatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Employee.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract EmployeeDAO getDao();
}
