package com.example.demo.supervillain;

import com.example.demo.power.Power;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "supervillains")
public class Supervillain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String alias;

    private Integer powerLevel;

    private Double evilLevel;

    private LocalDate firstCrimeDate;

    @ManyToMany
    @JoinTable(
            name = "supervillain_powers",
            joinColumns = @JoinColumn(name = "supervillain_id"),
            inverseJoinColumns = @JoinColumn(name = "power_id")
    )
    private List<Power> powers;

    @Enumerated(EnumType.STRING)
    private VillainStatus status;

    public Supervillain() {}

    public Supervillain(String name, String alias, Integer powerLevel, Double evilLevel, LocalDate firstCrimeDate, List<Power> powers) {
        this.name = name;
        this.alias = alias;
        this.powerLevel = powerLevel;
        this.evilLevel = evilLevel;
        this.firstCrimeDate = firstCrimeDate;
        this.powers = powers;
        this.status = VillainStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
    }

    public Double getEvilLevel() {
        return evilLevel;
    }

    public void setEvilLevel(Double evilLevel) {
        this.evilLevel = evilLevel;
    }

    public LocalDate getFirstCrimeDate() {
        return firstCrimeDate;
    }

    public void setFirstCrimeDate(LocalDate firstCrimeDate) {
        this.firstCrimeDate = firstCrimeDate;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public VillainStatus getStatus() {
        return status;
    }

    public void setStatus(VillainStatus status) {
        this.status = status;
    }
}
