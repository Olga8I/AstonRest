package org.example.model;

/**
 * Phone entity
 * One To One: PhoneNumber - User
 */
public class PhoneNumber {

    private Long id;
    private String number;
    private User user;


    public PhoneNumber(Long id, String number, User user) {
        this.id = id;
        this.number = number;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setUser(User user) {
        this.user = user;
    }
}