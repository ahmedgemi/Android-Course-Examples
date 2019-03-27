package com.ahmed.listviewstudent;

import android.net.Uri;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String grade;
    private  String image;

    public Student(String name, String grade, String image) {
        this.name = name;
        this.grade = grade;
        this.image = image;
    }

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




}
