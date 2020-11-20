package com.safetynet.alerts.model;

import java.util.Arrays;

public class MedicalRecord {

    private String firstName;

    private String lastName;

    private String birthdate;

    private String[] medications;

    private String[] allergies;

    public MedicalRecord() {
    }

    public MedicalRecord(String firstName, String lastName, String birthdate, String[] medications, String[] allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.medications = medications.clone();
        this.allergies = allergies.clone();
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
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String[] getMedications() { return medications; }
    public void setMedications(String[] medications) { this.medications = medications.clone(); }
    public String[] getAllergies() { return allergies.clone(); }
    public void setAllergies(String[] allergies) {
        this.allergies = allergies.clone();
    }
}