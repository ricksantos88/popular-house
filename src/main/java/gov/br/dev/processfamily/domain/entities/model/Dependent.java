package gov.br.dev.processfamily.domain.entities.model;

import java.math.BigDecimal;

public class Dependent {
    private Family family;
    private String name;

    private Integer age;

    private BigDecimal Income;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getIncome() {
        return Income;
    }

    public void setIncome(BigDecimal income) {
        Income = income;
    }
}
