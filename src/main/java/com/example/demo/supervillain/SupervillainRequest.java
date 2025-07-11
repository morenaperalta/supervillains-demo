package com.example.demo.supervillain;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record SupervillainRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Alias is required")
        @Size(min = 2, max = 100, message = "Alias must be between 2 and 100 characters")
        String alias,

        @Email(message = "Invalid email format")
        String villainMail,

        @NotNull(message = "Power level is required")
        @Min(value = 1, message = "Power level must be at least 1")
        @Max(value = 10, message = "Power level cannot exceed 10")
        Integer powerLevel,

        @NotNull(message = "Evil level is required")
        @DecimalMin(value = "51.0", message = "Evil level must be at least 51.0")
        @DecimalMax(value = "100.0", message = "Evil level cannot exceed 100.0")
        Double evilLevel,

        @NotNull(message = "First crime date is required")
        @PastOrPresent(message = "First crime date cannot be in the future")
        LocalDate firstCrimeDate,

        @Size(max = 10, message = "Maximum 10 powers allowed")
        List<@NotBlank(message = "Power name cannot be blank") String> powersNames,

        @NotNull(message = "Status is required")
        VillainStatus status
) {
}
