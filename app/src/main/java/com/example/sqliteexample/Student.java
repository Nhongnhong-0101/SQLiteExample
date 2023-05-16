package com.example.sqliteexample;

public class Student {
    private String id;
    private String name;
    private int image;
    private String dob;
    private String classID;

    public Student(String id, String name, int image, String dob, String classID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.dob = dob;
        this.classID = classID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
