package ru.barsky.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CountryDto(
    val id: Int? = null,

    @NotBlank
    @Min(2)
    val name: String,

    @NotNull
    @Min(1)
    val population: Int,

    @NotEmpty
    val cities: List<CityDto>,
)
