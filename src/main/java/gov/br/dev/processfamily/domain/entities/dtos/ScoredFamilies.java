package gov.br.dev.processfamily.domain.entities.dtos;

import gov.br.dev.processfamily.domain.entities.model.Family;

public class ScoredFamilies {

    private Family family;
    private Integer points;

    public ScoredFamilies(Family family) {
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
