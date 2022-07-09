package com.weekenddevelopers.studentmanagementsystem.model;

public class RecyclerModel {
    private String recycleName,recycleCGPA;

    public RecyclerModel(String recycleName, String recycleCGPA) {
        this.recycleName = recycleName;
        this.recycleCGPA = recycleCGPA;
    }

    public String getRecycleName() {
        return recycleName;
    }

    public void setRecycleName(String recycleName) {
        this.recycleName = recycleName;
    }

    public String getRecycleCGPA() {
        return recycleCGPA;
    }

    public void setRecycleCGPA(String recycleCGPA) {
        this.recycleCGPA = recycleCGPA;
    }
}
