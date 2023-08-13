package com.sandeep.springbootdemo.enums;

public enum User {
    ADMIN("ROLE_ADMIN", "Read Write"),
    USER("ROLE_ADMIN", "Read");
    private String role;
    private String operation;

    User(String role, String operation) {
        this.role = role;
        this.operation = operation;
    }

    public String getRole() {
        return role;
    }

    public String getOperation() {
        return operation;
    }
}
