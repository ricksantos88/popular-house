package gov.br.dev.processfamily.domain.entities.model;

import java.math.BigDecimal;
import java.util.List;

public class Family {

    private Long id;
    private String responsible;
    private List<Dependent> dependents;
    private Spouse spouse;
    private BigDecimal income;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    public void setDependents(List<Dependent> dependents) {
        this.dependents = dependents;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getFamilyIncome() {
        BigDecimal income = BigDecimal.ZERO;
        income = income.add(this.income);

        for (Dependent dependent : this.dependents) {
            income = income.add(dependent.getIncome());
        }

        return income;
    }
}
