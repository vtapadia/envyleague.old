package com.github.vtapadia.envyleague.domain.key;

import com.github.vtapadia.envyleague.domain.Team;
import com.github.vtapadia.envyleague.domain.Tournament;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Primary Key for Tournament Teams
 */
@Embeddable
public class TournamentTeamKey implements Serializable {
    @ManyToOne
    private Tournament tournament;

    @ManyToOne
    private Team team;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
