package com.example.foodorderingapplication.dto.user;

import com.example.foodorderingapplication.db.entities.Role;

public class UserProfile {

    private Long id;
    private String username;
    private String address;
    private Role role;
    private String email;

    public UserProfile(Long id, String username, String address, Role role, String email) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.role = role;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
