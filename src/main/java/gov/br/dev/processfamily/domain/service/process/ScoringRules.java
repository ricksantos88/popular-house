package gov.br.dev.processfamily.domain.service.process;

import gov.br.dev.processfamily.domain.entities.model.Family;

public interface ScoringRules {

    Integer incomeUpTo900BRL(Family family);
    Integer incomeBetween901To1500BRL(Family family);
    Integer FamiliesWithOneOrTwoDependents(Family family);
    Integer FamiliesWithThreeOrMoreDependents(Family family);
}
