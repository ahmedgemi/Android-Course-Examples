package com.ahmed.myapplication;

import java.io.Serializable;

public class Student implements Serializable {

    int id;
    String name;
    int grade;

    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
