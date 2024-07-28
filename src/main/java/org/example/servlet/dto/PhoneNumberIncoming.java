package org.example.servlet.dto;

public class PhoneNumberIncoming {
    private String number;
    public PhoneNumberIncoming() {

    }
    public PhoneNumberIncoming(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
