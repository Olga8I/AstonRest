package org.example.servlet.dto;


public class PhoneNumberOutGoing {
    private Long id;
    private String number;

    public PhoneNumberOutGoing() {
    }

    public PhoneNumberOutGoing(Long id, String number, UserSmallOutGoingDto userDto) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}

