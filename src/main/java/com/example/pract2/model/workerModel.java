package com.example.pract2.model;

public class workerModel {
    private int Id;
    private String Name;
    private String LastName;
    private String FirstName;
    private String Job;

    public workerModel(int id, String name, String lastName, String firstName, String job) {
        Id = id;
        Name = name;
        LastName = lastName;
        FirstName = firstName;
        Job = job;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }
}

