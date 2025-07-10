package com.example.demo.supervillain;

import com.example.demo.power.Power;
import com.example.demo.power.PowerMapper;
import com.example.demo.power.PowerResponse;

import java.util.List;


public class SupervillainMapper {
    public static Supervillain toEntity(SupervillainRequest request, List<Power> powers) {
        return new Supervillain(
                request.name(),
                request.alias(),
                request.villainMail(),
                request.powerLevel(),
                request.evilLevel(),
                request.firstCrimeDate(),
                powers,
                request.status()
        );
    }

    public static SupervillainResponse toDto(Supervillain supervillain) {
        List<Power> powers = supervillain.getPowers();
        List<PowerResponse> powerResponses = powers != null
                ? powers.stream().map(PowerMapper::toDto).toList()
                : List.of();

        return new SupervillainResponse(
                supervillain.getId(),
                supervillain.getName(),
                supervillain.getAlias(),
                supervillain.getVillainMail(),
                supervillain.getPowerLevel(),
                supervillain.getEvilLevel(),
                supervillain.getFirstCrimeDate(),
                powerResponses,
                supervillain.getStatus()
        );
    }
}
