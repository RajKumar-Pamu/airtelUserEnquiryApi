package com.example.demo.service;

public class CustomResponse {
    private String fullName;
    private String registrationStatus;
    private String errorMessage;

    // Constructors, getters, and setters

    // Constructors
    public CustomResponse() {
    }

    public CustomResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
