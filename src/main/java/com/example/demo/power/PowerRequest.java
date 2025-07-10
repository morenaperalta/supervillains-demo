package com.example.demo.power;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PowerRequest(
        @NotBlank(message = "Power name must not be empty")
        @Size(min = 2, max = 50, message = "Power name must contain min 2 and max 50 characters")
        String name,
        @NotBlank(message = "Description must not be empty")
        @Size(min = 10, max = 150, message = "Description must contain min 10 and max 150 characters")
        String description) {
}
