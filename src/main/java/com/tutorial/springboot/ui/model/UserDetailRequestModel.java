package com.tutorial.springboot.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {

    @NotNull
    @Size(min = 2, message = "FirstName length must be grater than 2")
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email
    private String emailAddress;

    @NotNull
    @Size(min = 8, max = 16, message = "Password size should be between 8 and 16")
    private String password;

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
