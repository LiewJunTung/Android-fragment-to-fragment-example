package com.example.jt.communicationbetweenfragmentsexample;

/**
 * Created by jt on 3/15/15.
 */
public class User {
    private String name;
    private String email;
    private int age;

    public User(String name, String email, int age) {

        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
