package com.example.demo;

public class Person {
    private String firstName;
    private String familyName;
    
    public Person()
    {
        
    }
    
    public Person(String firstName, String familyName)
    {
        this.firstName = firstName;
        this.familyName = familyName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }
}