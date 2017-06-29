package com.github.vtapadia.envyleague.domain.football;

import com.github.vtapadia.envyleague.domain.AbstractPrediction;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Prediction for a football match
 */
@Entity
@Table
public class FootballPrediction extends AbstractPrediction {

    @EmbeddedId
    private FootballPredictionKey footballPredictionKey;
    @Column
    private Integer teamAScore;

    @Column
    private Integer teamBScore;

    public FootballPredictionKey getFootballPredictionKey() {
        return footballPredictionKey;
    }

    public void setFootballPredictionKey(FootballPredictionKey footballPredictionKey) {
        this.footballPredictionKey = footballPredictionKey;
    }

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
}
