package com.safetynet.alerts.model;

import java.util.List;

public class ChildAlert {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<String> family;

    public ChildAlert() { }

    public ChildAlert(String firstName, String lastName, Integer age, List<String> family) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.family = family;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() { return age; }
    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFamily() { return family; }
    public void setFamily(List<String> family) {
        this.family = family;
    }
}
