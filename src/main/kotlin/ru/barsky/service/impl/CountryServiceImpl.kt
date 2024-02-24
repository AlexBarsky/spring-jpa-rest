package ru.barsky.service.impl

import org.springframework.stereotype.Service
import ru.barsky.dto.CountryDto
import ru.barsky.service.CountryService

@Service
class CountryServiceImpl : CountryService {
    override fun getAllCountries(): List<CountryDto> {
        return listOf(
            CountryDto(
                id = 1,
                name = "Russia",
                capital = "Moscow",
                population = 100000000,
                region = "Europe"
            ),
            CountryDto(
                id = 2,
                name = "USA",
                capital = "Washington",
                population = 100000000,
                region = "North America"
            ),
            CountryDto(
                id = 3,
                name = "China",
                capital = "Beijing",
                population = 100000000,
                region = "Asia"
            ),
            CountryDto(
                id = 4,
                name = "Japan",
                capital = "Tokyo",
                population = 100000000,
                region = "Asia"
            ),
        )
    }
}