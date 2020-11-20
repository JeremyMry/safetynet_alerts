package com.safetynet.alerts.model;

import java.util.List;

public class Flood {

    private String firstName;

    private String lastName;

    private Integer age;

    private String phone;

    private String[] medications;

    private String[] allergies;


    public Flood() {
    }

    public Flood(String firstName, String lastName, int age, String phone, String[] medications, String[] allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.medications = medications.clone();
        this.allergies = allergies.clone();
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getAge() { return this.age; }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() { return phone; }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String[] getMedications() { return medications.clone(); }
    public void setMedications(String[] medications) {
        this.medications = medications.clone();
    }
    public String[] getAllergies() { return allergies.clone(); }
    public void setAllergies(String[] allergies) {
        this.allergies = allergies.clone();
    }
}
