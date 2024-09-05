package com.example.pract2.model;

public class jurnalModel {
    private int Id;
    private String Name;
    private String LastName;
    private String FirstName;
    private String MiddleName;

    private boolean IsDeleted;

    public jurnalModel(int id, String name, String lastName, String firstName, String middleName, boolean isDeleted) {
        Id = id;
        Name = name;
        LastName = lastName;
        FirstName = firstName;
        MiddleName = middleName;
        IsDeleted = isDeleted;
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

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public boolean getisDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }
}

