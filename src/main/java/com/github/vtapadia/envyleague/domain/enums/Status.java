package com.github.vtapadia.envyleague.domain.enums;

/**
 * Status enum
 */
public enum Status {
    ACTIVE("Registered"),
    PENDING("Pending Approval"),
    CANCELLED("Rejected");

    private String description;
    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

