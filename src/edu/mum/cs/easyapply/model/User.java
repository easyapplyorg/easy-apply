package edu.mum.cs.easyapply.model;

public class User {
    int userId;
    String firstName;
    String lastName;
    String address;
    String phoneNumber;
    String email;
    String joinedDate;

    public User() {
    }

    public User(String firstName, String lastName, String address, String phoneNumber, String email, String joinedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.joinedDate = joinedDate;
    }

    public User(int userId, String firstName, String lastName, String address, String phoneNumber, String email, String joinedDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.joinedDate = joinedDate;
    }

    public int getUserId() {
        return userId;
    }

    public User setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public User setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
        return this;
    }
}
