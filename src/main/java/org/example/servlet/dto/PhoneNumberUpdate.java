package org.example.servlet.dto;


public class PhoneNumberUpdate {
    private Long id;
    private String number;
    private Long userId;


    public PhoneNumberUpdate(Long id, String number, Long userId) {
        this.id = id;
        this.number = number;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Long getUserId() {
        return userId;
    }

}

