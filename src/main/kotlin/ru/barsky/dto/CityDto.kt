package ru.barsky.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class CityDto(
    @NotBlank
    @Min(2)
    val name: String,
)
