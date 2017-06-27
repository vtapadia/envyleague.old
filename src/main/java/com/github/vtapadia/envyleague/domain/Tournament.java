package com.github.vtapadia.envyleague.domain;

import com.github.vtapadia.envyleague.domain.enums.Status;
import com.github.vtapadia.envyleague.domain.enums.TournamentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Identifies all the Tournaments
 */
@Entity
@Table
public class Tournament {
    @NotNull
    @Size(min = 1, max = 50)
    @Id
    @Column(length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TournamentType type;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TournamentType getType() {
        return type;
    }

    public void setType(TournamentType type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
