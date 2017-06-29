package com.github.vtapadia.envyleague.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * League where multiple people can participates and play together.
 */
@Entity
@Table
public class League {
    @NotNull
    @Size(max = 50)
    @Id
    @Column(length = 50)
    private String name;

    @Column
    private int fee;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private AppUser owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}
