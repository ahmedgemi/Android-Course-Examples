package com.ahmed.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface EmployeeDAO {

    @Insert
    void addEmployee(Employee employee);

    @Query("SELECT * FROM employee")
    List<Employee> getAll();

    @Query("SELECT * FROM employee where mySalary > :salary")
    List<Employee> filterBySalary(int salary);

    @Query("SELECT * FROM employee where id = :id LIMIT 1")
    Employee getEmployee(int id);

    @Delete
    void deleteEmployee(Employee employee);
}
