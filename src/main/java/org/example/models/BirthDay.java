package org.example.models;

import java.time.LocalDate;

public class BirthDay extends Event {
    private String gender;
    private boolean isRelative;
    private String firstName;
    private String lastName;

    public BirthDay(LocalDate eventDate, String gender, boolean isRelative, String firstName, String lastName) {
        super(eventDate);
        this.gender = gender;
        this.isRelative = isRelative;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isRelative() {
        return isRelative;
    }

    public void setRelative(boolean relative) {
        isRelative = relative;
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
}
