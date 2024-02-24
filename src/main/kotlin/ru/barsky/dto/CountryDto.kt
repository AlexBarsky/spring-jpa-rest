package ru.barsky.dto

data class CountryDto(
    val id: Long,
    val name: String,
    val capital: String,
    val population: Int,
    val region: String,
)
