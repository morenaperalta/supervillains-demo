package com.example.demo.supervillain;

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

    private Double evilLevel;

    private LocalDate firstCrimeDate;

    private List<String> powers;

    @Enumerated(EnumType.STRING)
    private VillainStatus status;

}
