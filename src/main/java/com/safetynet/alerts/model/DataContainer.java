package com.safetynet.alerts.model;

import com.safetynet.alerts.model.crud.Firestation;
import com.safetynet.alerts.model.crud.MedicalRecord;
import com.safetynet.alerts.model.crud.Person;

import java.util.List;

public class DataContainer {


    private List<Person> persons;

    private List<Firestation> firestations;

    private List<MedicalRecord> medicalrecords;

    public DataContainer() {
    }

    public DataContainer(List<Person> persons, List<Firestation> firestations, List<MedicalRecord> medicalrecords) {
        this.persons = persons;
        this.firestations = firestations;
        this.medicalrecords = medicalrecords;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setFirestations(List<Firestation> firestations) {
        this.firestations = firestations;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public List<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }

    public List<Firestation> getFirestations() {
        return firestations;
    }

    @Override
    public String toString() {
        return "Model [persons=" + persons + ", medicalrecord=" + medicalrecords + ", firestations="
                + firestations + "]";
    }

}
