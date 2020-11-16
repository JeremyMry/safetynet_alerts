package com.safetynet.alerts.model;

import com.safetynet.alerts.model.crud.Person;

import java.util.List;

public class StationCoverage {

    private int adults;
    private int childs;
    private List<Person> personsCovered;

    public StationCoverage(int nbAdults, int nbChilds, List<Person> personsCovered) {
        this.adults = nbAdults;
        this.childs = nbChilds;
        this.personsCovered = personsCovered;

    }

    public int getAdults() {
        return adults;
    }
    public int getChilds() {
        return childs;
    }
    public List<Person> getPersonsCovered() {
        return personsCovered;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }
    public void setChilds(int childs) {
        this.childs = childs;
    }
    public void setPersonsCovered(List<Person> personsCovered) {
        this.personsCovered = personsCovered;
    }

    @Override
    public String toString() {
        return "PersonInfo [There is " + adults + " adults and " + childs + " childs covered. This the list of all the persons covered: " + personsCovered + "]";
    }
}
