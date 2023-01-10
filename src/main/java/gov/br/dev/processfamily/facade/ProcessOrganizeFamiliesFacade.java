package gov.br.dev.processfamily.facade;

import gov.br.dev.processfamily.domain.entities.dtos.ScoredFamilies;
import gov.br.dev.processfamily.domain.entities.model.Family;
import gov.br.dev.processfamily.domain.service.process.ScoringRules;
import gov.br.dev.processfamily.domain.service.SelectFamiliesService;
import gov.br.dev.processfamily.domain.service.process.rules.Rules;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessOrganizeFamiliesFacade {

    private final ScoringRules scoringRules = new Rules();

    private final SelectFamiliesService service = new SelectFamiliesService();

    public List<ScoredFamilies> process() {
        List<ScoredFamilies> scoredFamilies = findFamiliesList()
                .stream()
                .map(ScoredFamilies::new)
                .collect(Collectors.toList());

        makeFamilyScore(scoredFamilies);

        return scoredFamilies
                .stream()
                .sorted(Comparator.comparing(ScoredFamilies::getPoints))
                .collect(Collectors.toList());

    }

    private void makeFamilyScore(List<ScoredFamilies> scoredFamilies) {
        scoredFamilies.forEach(scoredFamily -> {
            scoredFamily.setPoints(scoringRules.incomeUpTo900BRL(scoredFamily.getFamily()));
            scoredFamily.setPoints(scoringRules.incomeBetween901To1500BRL(scoredFamily.getFamily()));
            scoredFamily.setPoints(scoringRules.FamiliesWithOneOrTwoDependents(scoredFamily.getFamily()));
            scoredFamily.setPoints(scoringRules.FamiliesWithThreeOrMoreDependents(scoredFamily.getFamily()));
        });
    }

    private List<Family> findFamiliesList() {
        return service.receiveFamily();
    }

}
