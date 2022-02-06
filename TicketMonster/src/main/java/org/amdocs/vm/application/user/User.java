package org.amdocs.vm.application.user;

import java.time.LocalDate;

public class User {

    public User(String id, String firstName, String middleInitial, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private String id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

}
