package com.github.vtapadia.envyleague.domain.football;

import com.github.vtapadia.envyleague.domain.AppUser;
import com.github.vtapadia.envyleague.domain.League;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 *
 */
@Embeddable
public class FootballPredictionKey implements Serializable {
    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private League league;

    @ManyToOne
    private FootballMatch footballMatch;

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

    public FootballMatch getFootballMatch() {
        return footballMatch;
    }

    public void setFootballMatch(FootballMatch footballMatch) {
        this.footballMatch = footballMatch;
    }
}
