package com.github.vtapadia.envyleague.domain.football;

import com.github.vtapadia.envyleague.domain.AbstractMatch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Football match
 */
@Entity
@Table
public class FootballMatch extends AbstractMatch {
    @Column
    private Integer teamAScore;
    @Column
    private Integer teamBScore;

    @Column
    private Integer teamAPenalty;
    @Column
    private Integer teamBPenalty;

    public Integer getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(Integer teamAScore) {
        this.teamAScore = teamAScore;
    }

    public Integer getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(Integer teamBScore) {
        this.teamBScore = teamBScore;
    }

    public Integer getTeamAPenalty() {
        return teamAPenalty;
    }

    public void setTeamAPenalty(Integer teamAPenalty) {
        this.teamAPenalty = teamAPenalty;
    }

    public Integer getTeamBPenalty() {
        return teamBPenalty;
    }

    public void setTeamBPenalty(Integer teamBPenalty) {
        this.teamBPenalty = teamBPenalty;
    }
}
