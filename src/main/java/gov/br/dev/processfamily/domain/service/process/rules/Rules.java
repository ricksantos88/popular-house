package gov.br.dev.processfamily.domain.service.process.rules;

import gov.br.dev.processfamily.domain.entities.model.Dependent;
import gov.br.dev.processfamily.domain.entities.model.Family;
import gov.br.dev.processfamily.domain.service.process.ScoringRules;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Rules implements ScoringRules {

    @Override
    public Integer incomeUpTo900BRL(Family family) {
        BigDecimal familyIncome = family.getIncome();
        if (familyIncome.compareTo(new BigDecimal(900)) > 0) {
            return 0;
        }
        return 5;
    }


    @Override
    public Integer incomeBetween901To1500BRL(Family family) {
        BigDecimal familyIncome = family.getIncome();
        if ((familyIncome.compareTo(new BigDecimal(901)) >= 0) && (familyIncome.compareTo(new BigDecimal(1500)) <= 0)) {
            return 0;
        }
        return 3;
    }

    @Override
    public Integer FamiliesWithOneOrTwoDependents(Family family) {
        if (filterDependentsPerAge(family).size() <= 2) {
            return 2;
        }
        return 0;
    }

    @Override
    public Integer FamiliesWithThreeOrMoreDependents(Family family) {
        if (filterDependentsPerAge(family).size() >= 3) {
            return 3;
        }
        return 0;
    }

    private static List<Dependent> filterDependentsPerAge(Family family) {
        return family.getDependents()
                .stream().filter(dependent -> dependent.getAge() < 18).collect(Collectors.toList());
    }


}
