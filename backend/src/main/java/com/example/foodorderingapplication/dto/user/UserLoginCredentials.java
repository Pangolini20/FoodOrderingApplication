package com.example.foodorderingapplication.dto.user;

public class UserLoginCredentials {

    private String username;
    private String notHashedPassword;

    public UserLoginCredentials(String username, String notHashedPassword) {
        this.username = username;
        this.notHashedPassword = notHashedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNotHashedPassword() {
        return notHashedPassword;
    }

    public void setNotHashedPassword(String notHashedPassword) {
        this.notHashedPassword = notHashedPassword;
    }

    @Override
    public String toString() {
        return "UserLoginCredentials{" +
                "username='" + username + '\'' +
                ", notHashedPassword='" + notHashedPassword + '\'' +
                '}';
    }
}
