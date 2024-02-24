package ru.barsky.service

import ru.barsky.dto.CountryDto

interface CountryService {

    fun getAllCountries(): List<CountryDto>
}