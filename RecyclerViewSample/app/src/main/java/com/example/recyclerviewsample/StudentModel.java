package com.example.recyclerviewsample;

public class StudentModel {

    String studentName;
    long studentPhone;

    public StudentModel(String studentName, long studentPhone) {
        this.studentName = studentName;
        this.studentPhone = studentPhone;
    }

    public long getStudentPhone() {
        return studentPhone;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentPhone(long studentPhone) {
        this.studentPhone = studentPhone;
    }
}
