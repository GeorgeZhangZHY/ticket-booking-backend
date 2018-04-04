package edu.nju.ticketbooking.model;

import edu.nju.ticketbooking.constant.Role;

public class AuthenticationInfo {

    private String key, password;

    private Role role;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
