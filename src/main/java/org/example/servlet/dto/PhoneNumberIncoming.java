package org.example.servlet.dto;

public class PhoneNumberIncoming {
    private String number;

    public PhoneNumberIncoming(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
