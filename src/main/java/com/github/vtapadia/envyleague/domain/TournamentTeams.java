package com.github.vtapadia.envyleague.domain;

import com.github.vtapadia.envyleague.domain.key.TournamentTeamKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * tracks teams that are there in a Tournament
 */
@Entity
@Table
public class TournamentTeams {
    @EmbeddedId
    private TournamentTeamKey tournamentTeamKey;

//    private String group;
//
//    private Integer points;

    public TournamentTeamKey getTournamentTeamKey() {
        return tournamentTeamKey;
    }

    public void setTournamentTeamKey(TournamentTeamKey tournamentTeamKey) {
        this.tournamentTeamKey = tournamentTeamKey;
    }

//    public String getGroup() {
//        return group;
//    }
//
//    public void setGroup(String group) {
//        this.group = group;
//    }
//
//    public Integer getPoints() {
//        return points;
//    }
//
//    public void setPoints(Integer points) {
//        this.points = points;
//    }
}
