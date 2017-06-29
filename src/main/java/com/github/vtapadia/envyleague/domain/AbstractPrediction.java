package com.github.vtapadia.envyleague.domain;

import javax.persistence.MappedSuperclass;

/**
 *
 */
@MappedSuperclass
public class AbstractPrediction {
    private Integer points;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
