package com.safetynet.alerts.model;

import java.util.List;

public class Flood {

    private String firstName;

    private String lastName;

    private Integer age;

    private String phone;

    private String address;

    private String[] medications;

    private String[] allergies;


    public Flood() {
    }

    public Flood(String firstName, String lastName, int age, String phone, String address, String[] medications, String[] allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.medications = medications;
        this.allergies = allergies;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getMedications() {
        return medications;
    }

    public void setMedications(String[] medications) {
        this.medications = medications;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", medications" + medications + ", allergies" + allergies + "]";
    }
}
