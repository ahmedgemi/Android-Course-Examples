package com.ahmed.roomdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//@Entity(tableName = "myEmployee")
@Entity
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    @ColumnInfo(name = "mySalary")
    public int salary;


    @Override
    public String toString() {

        return String.valueOf(id) + " - "+name + " - " + String.valueOf(salary);
    }
}
