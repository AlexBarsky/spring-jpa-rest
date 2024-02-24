package ru.barsky.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ru.barsky.dto.CountryDto
import ru.barsky.entity.CountryEntity
import ru.barsky.repository.CountryRepository
import ru.barsky.service.CountryService

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
) : CountryService {

    override fun getAllCountries(pageIndex: Int): List<CountryDto> =
        countryRepository.findByOrderByName(PageRequest.of(pageIndex, 3)).map { it.toDto() }

    private fun CountryEntity.toDto(): CountryDto =
        CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
        )
}