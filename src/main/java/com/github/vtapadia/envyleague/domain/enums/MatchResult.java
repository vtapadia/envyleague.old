package com.github.vtapadia.envyleague.domain.enums;

/**
 * Match Results that are possible outcome of a match
 */
public enum MatchResult {
    /**
     * No Winner, match is drawn.
     * Or match is cancelled/rained.
     *
     * Points are to be shared by both the teams
     */
    DRAW,
    /**
     * There is a winner in the match.
     */
    FINISHED;
}
