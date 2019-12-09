package com.amber;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }
}
