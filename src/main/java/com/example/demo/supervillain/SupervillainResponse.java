package com.example.demo.supervillain;

import com.example.demo.power.PowerResponse;

import java.time.LocalDate;
import java.util.List;

public record SupervillainResponse(
        Long id,
        String name,
        String alias,
        String villainMail,
        Integer powerLevel,
        Double evilLevel,
        LocalDate firstCrimeDate,
        List<PowerResponse> powers,
        VillainStatus status
        ) {

}
