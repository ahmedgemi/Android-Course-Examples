package com.ahmed.listview2;

public class Student {
    private String name;
    private String className;
    private int grade;

    public Student(String name, String className, int grade) {
        this.name = name;
        this.className = className;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
