package com.example.demo.supervillain;

import com.example.demo.power.Power;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "supervillains")
public class Supervillain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;

    @NotBlank(message = "Alias must not be blank")
    @Size(min = 2, max = 20, message = "Alias must be between 2 and 20 characters")
    private String alias;

    @Email
    private String villainMail;

    private Integer powerLevel;

    private Double evilLevel;

    private LocalDate firstCrimeDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "supervillain_powers",
            joinColumns = @JoinColumn(name = "supervillain_id"),
            inverseJoinColumns = @JoinColumn(name = "power_id")
    )
    private List<Power> powers;

    @Enumerated(EnumType.STRING)
    private VillainStatus status;

    public Supervillain() {}

    public Supervillain(String name, String alias, String villainMail, Integer powerLevel, Double evilLevel, LocalDate firstCrimeDate, List<Power> powers, VillainStatus status) {
        this.name = name;
        this.alias = alias;
        this.villainMail = villainMail;
        this.powerLevel = powerLevel;
        this.evilLevel = evilLevel;
        this.firstCrimeDate = firstCrimeDate;
        this.powers = powers;
        this.status = status;
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

    public String getVillainMail() {
        return villainMail;
    }

    public void setVillainMail(String villainMail) {
        this.villainMail = villainMail;
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
