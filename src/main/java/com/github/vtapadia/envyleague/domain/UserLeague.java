package com.github.vtapadia.envyleague.domain;

import com.github.vtapadia.envyleague.domain.enums.Status;
import com.github.vtapadia.envyleague.domain.key.UserLeagueKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Maps users to a league.
 */
@Table
@Entity
public class UserLeague {
    @EmbeddedId
    private UserLeagueKey userLeagueKey;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public UserLeagueKey getUserLeagueKey() {
        return userLeagueKey;
    }

    public void setUserLeagueKey(UserLeagueKey userLeagueKey) {
        this.userLeagueKey = userLeagueKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
