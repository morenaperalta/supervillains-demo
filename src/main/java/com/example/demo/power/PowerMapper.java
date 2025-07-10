package com.example.demo.power;

public class PowerMapper {
    public static Power toEntity(PowerRequest request) {
        return new Power(request.name(), request.description());
    }

    public static PowerResponse toDto(Power power) {
        return new PowerResponse(power.getId(), power.getName(), power.getDescription());
    }
}
