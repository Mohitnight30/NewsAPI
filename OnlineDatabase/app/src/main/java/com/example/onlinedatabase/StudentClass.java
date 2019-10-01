package com.example.onlinedatabase;

public class StudentClass {

    String name, college;

    public StudentClass(String name, String college) {
        this.name = name;
        this.college = college;
    }

    public String getCollege() {
        return college;
    }

    public String getName() {
        return name;
    }
}
