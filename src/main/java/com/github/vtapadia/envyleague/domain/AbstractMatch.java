package com.github.vtapadia.envyleague.domain;

import com.github.vtapadia.envyleague.domain.enums.MatchResult;
import com.github.vtapadia.envyleague.domain.enums.MatchType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Basic match values that are required.
 */
@MappedSuperclass
public abstract class AbstractMatch {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Tournament tournament;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private MatchType matchType;

    @NotNull
    @Column
    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn
    private Team teamA;

    @ManyToOne
    @JoinColumn
    private Team teamB;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private MatchResult matchResult;

    @ManyToOne
    private Team winner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(MatchResult matchResult) {
        this.matchResult = matchResult;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
