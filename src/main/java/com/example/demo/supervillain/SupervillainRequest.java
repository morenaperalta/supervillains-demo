package com.example.demo.supervillain;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record SupervillainRequest(

        @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Alias must not be blank")
        @Size(min = 2, max = 20, message = "Alias must be between 2 and 20 characters")
        String alias,

        @Email(message = "Email must be with correct format")
        String villainMail,

        @Min(1)
        @Max(10)
        Integer powerLevel,

        @DecimalMin(value = "51.0", message = "Evil level cannot be minor of 51")
        @DecimalMax(value = "100.0", message = "Evil level cannot be major than 100")
        Double evilLevel,

        @PastOrPresent(message = "The date of crime cannot be future")
        LocalDate firstCrimeDate,

        List<String> powersNames,

        VillainStatus status
) {
}
