package ru.barsky.service

import ru.barsky.dto.CountryDto

interface CountryService {

    fun getAllCountries(pageIndex: Int): List<CountryDto>

    fun getCountryById(id: Long): CountryDto

    fun search(prefix: String): List<CountryDto>

    fun createCountry(countryDto: CountryDto): Long

    fun updateCountry(id: Long, countryDto: CountryDto)

    fun deleteCountry(id: Long)
}