package com.example.demo.supervillain;

import java.time.LocalDate;
import java.util.List;

public record SupervillainRequest(

        String name,

        String alias,

        String villainMail,

        Integer powerLevel,

        Double evilLevel,

        LocalDate firstCrimeDate,

        List<String> powersNames,

        VillainStatus status
) {
}
