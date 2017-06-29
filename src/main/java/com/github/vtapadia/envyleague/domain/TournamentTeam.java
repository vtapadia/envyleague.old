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
public class TournamentTeam {
    @EmbeddedId
    private TournamentTeamKey tournamentTeamKey;

    private String teamGroup;

    private Integer points;

    public TournamentTeamKey getTournamentTeamKey() {
        return tournamentTeamKey;
    }

    public void setTournamentTeamKey(TournamentTeamKey tournamentTeamKey) {
        this.tournamentTeamKey = tournamentTeamKey;
    }

    public String getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(String teamGroup) {
        this.teamGroup = teamGroup;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
