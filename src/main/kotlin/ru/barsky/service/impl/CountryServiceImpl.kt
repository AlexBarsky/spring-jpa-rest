package ru.barsky.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.barsky.dto.CountryDto
import ru.barsky.entity.CountryEntity
import ru.barsky.exception.CountryNotFoundException
import ru.barsky.repository.CountryRepository
import ru.barsky.service.CountryService

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
) : CountryService {

    override fun getAllCountries(pageIndex: Int): List<CountryDto> =
        countryRepository.findByOrderByName(PageRequest.of(pageIndex, 3)).map { it.toDto() }

    override fun getCountryById(id: Long): CountryDto =
        countryRepository.findByIdOrNull(id)
            ?.toDto()
            ?:  throw CountryNotFoundException(id)

    override fun search(prefix: String): List<CountryDto> =
        countryRepository.findByNameStartsWithIgnoreCaseOrderByName(prefix)
         .map { it.toDto() }

    override fun createCountry(countryDto: CountryDto): Long {
        return countryRepository.save(countryDto.toEntity()).id
    }

    override fun updateCountry(id: Long, countryDto: CountryDto) {
        val existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)

        existingCountry.name = countryDto.name
        existingCountry.population = countryDto.population

        countryRepository.save(existingCountry)
    }

    override fun deleteCountry(id: Long) {
        val existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)

        countryRepository.deleteById(existingCountry.id)
    }

    private fun CountryEntity.toDto(): CountryDto =
        CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
        )

    private fun CountryDto.toEntity(): CountryEntity =
        CountryEntity(
            id = 0,
            name = this.name,
            population = this.population,
        )
}