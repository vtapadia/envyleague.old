package com.github.vtapadia.envyleague.domain.key;

import com.github.vtapadia.envyleague.domain.AppUser;
import com.github.vtapadia.envyleague.domain.League;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Primary Key for the UserLeague entity
 */
@Embeddable
public class UserLeagueKey implements Serializable {
    @ManyToOne
    @JoinColumn
    private AppUser appUser;

    @ManyToOne
    @JoinColumn
    private League league;

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
