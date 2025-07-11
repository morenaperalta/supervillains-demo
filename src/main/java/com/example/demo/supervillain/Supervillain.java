package com.example.demo.supervillain;

import com.example.demo.power.Power;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "supervillains")
public class Supervillain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Alias is required")
    @Size(min = 2, max = 100, message = "Alias must be between 2 and 100 characters")
    private String alias;

    @Email(message = "Invalid email format")
    private String villainMail;

    @NotNull(message = "Power level is required")
    @Min(value = 1, message = "Power level must be at least 1")
    @Max(value = 10, message = "Power level cannot exceed 10")
    private Integer powerLevel;

    @NotNull(message = "Evil level is required")
    @DecimalMin(value = "51.0", message = "Evil level must be at least 51.0")
    @DecimalMax(value = "100.0", message = "Evil level cannot exceed 100.0")
    private Double evilLevel;

    @NotNull(message = "First crime date is required")
    @PastOrPresent(message = "First crime date cannot be in the future")
    private LocalDate firstCrimeDate;

    @Size(max = 10, message = "Maximum 10 powers allowed")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "supervillain_powers",
            joinColumns = @JoinColumn(name = "supervillain_id"),
            inverseJoinColumns = @JoinColumn(name = "power_id")
    )
    private List<Power> powers;

    @NotNull(message = "Status is required")
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
