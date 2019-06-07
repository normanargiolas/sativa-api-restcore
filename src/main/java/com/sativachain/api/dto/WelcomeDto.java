package com.sativachain.api.dto;

public class WelcomeDto {

    private String message;

    public WelcomeDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("welcomeDto [message=%s]", message);
    }

}
