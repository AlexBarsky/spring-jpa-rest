package ru.barsky.service

import ru.barsky.dto.CountryDto

interface CountryService {

    fun getAllCountries(pageIndex: Int): List<CountryDto>

    fun getCountryById(id: Int): CountryDto

    fun search(prefix: String): List<CountryDto>

    fun getAllCountryNames(): List<String>

    fun createCountry(countryDto: CountryDto): Int

    fun updateCountry(id: Int, countryDto: CountryDto)

    fun deleteCountry(id: Int)
}