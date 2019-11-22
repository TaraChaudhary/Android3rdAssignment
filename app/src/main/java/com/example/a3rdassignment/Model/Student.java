package com.example.a3rdassignment.Model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String age;
    private String gender;
    private String address;
    private int image;

    public Student(String name, String age, String gender, String address, int image) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.image=image;

    }

    public String getName() {

        return name;

    }

    public String getAge() {

        return age;

    }

    public String getGender()
    {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public int getImage() {
        return image;

    }
}
