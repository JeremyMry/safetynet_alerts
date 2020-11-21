package com.safetynet.alerts.model;

import java.util.List;

public class StationCoverage {

    private int adults;
    private int child;
    private List<PersonCovered> personsCovered;

    public StationCoverage() {}

    public StationCoverage(int nbAdults, int nbChild, List<PersonCovered> personsCovered) {
        this.adults = nbAdults;
        this.child = nbChild;
        this.personsCovered = personsCovered;
    }

    public int getAdults() { return adults; }
    public int getChild() { return child; }

    public List<PersonCovered> getPersonsCovered() { return personsCovered; }
    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChild(int child) {
        this.child = child;
    }
    public void setPersonsCovered(List<PersonCovered> personsCovered) {
        this.personsCovered = personsCovered;
    }
}
