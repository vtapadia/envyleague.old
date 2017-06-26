package com.github.vtapadia.envyleague.domain.enums;

/**
 * Various Match Types
 */
public enum MatchType {
    /**
     * League matches or group matches
     */
    LEAGUE(1),
    /**
     * Quater Finals earns you twice the rewards
     */
    QUARTER_FINAL(2),
    /**
     * Semi final earns you thrice the rewards
     */
    SEMI_FINAL(3),
    /**
     * Final match, earns you 4 times the rewards.
     */
    FINAL(4)
    ;

    private int multiplier;

    MatchType(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
