package com.safetynet.alerts.model;

import java.util.List;

public class FireAlert {

    private String firstName;

    private String lastName;

    private Integer age;

    private String phone;

    private String[] medications;

    private String[] allergies;

    private List<String> stationNumber;

    public FireAlert() {
    }

    public FireAlert(String firstName, String lastName, int age, String phone, String[] medications, String[] allergies, List<String> stationNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.medications = medications;
        this.allergies = allergies;
        this.stationNumber = stationNumber;
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

    public List<String> getStationNumber() { return stationNumber;}

    public void setStationNumber(List<String> stationNumber) { this.stationNumber = stationNumber; }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", medications" + medications + ", allergies" + allergies + ", stationNumber=" + stationNumber +"]";
    }
}
