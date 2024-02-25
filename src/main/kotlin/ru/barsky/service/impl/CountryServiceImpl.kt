package ru.barsky.service.impl

import jakarta.transaction.Transactional
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.barsky.dto.CityDto
import ru.barsky.dto.CountryDto
import ru.barsky.entity.CityEntity
import ru.barsky.entity.CountryEntity
import ru.barsky.exception.CountryNotFoundException
import ru.barsky.repository.CityRepository
import ru.barsky.repository.CountryRepository
import ru.barsky.service.CountryService

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
    private val cityRepository: CityRepository,
) : CountryService {

    override fun getAllCountries(pageIndex: Int): List<CountryDto> =
        countryRepository.findByOrderByName(PageRequest.of(pageIndex, 3)).map { it.toDto() }

    override fun getCountryById(id: Int): CountryDto =
        countryRepository.findByIdOrNull(id)
            ?.toDto()
            ?:  throw CountryNotFoundException(id)

    override fun search(prefix: String): List<CountryDto> =
        countryRepository.findByNameStartsWithIgnoreCaseOrderByName(prefix)
         .map { it.toDto() }

    override fun getAllCountryNames(): List<String> =
        countryRepository.findAllByOrderByName().map { it.name }

    @Transactional
    override fun createCountry(countryDto: CountryDto): Int {
        val countryEntity = countryRepository.save(countryDto.toEntity())
        val cities = countryDto.cities.map { it.toEntity(countryEntity) }

        cityRepository.saveAll(cities)

        return countryEntity.id
    }

    @Transactional
    override fun updateCountry(id: Int, countryDto: CountryDto) {
        var existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)

        existingCountry.name = countryDto.name
        existingCountry.population = countryDto.population

        existingCountry = countryRepository.save(existingCountry)

        val cities = countryDto.cities.map { it.toEntity(existingCountry) }

        cityRepository.deleteAllByCountry(existingCountry)
        cityRepository.saveAll(cities)
    }

    @Transactional
    override fun deleteCountry(id: Int) {
        val existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)

        cityRepository.deleteAllByCountry(existingCountry)
        countryRepository.deleteById(existingCountry.id)
    }

    private fun CountryEntity.toDto(): CountryDto =
        CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
            cities = this.cities.map { it.toDto() },
        )

    private fun CityEntity.toDto(): CityDto =
        CityDto(
            name = this.name,
        )

    private fun CountryDto.toEntity(): CountryEntity =
        CountryEntity(
            id = 0,
            name = this.name,
            population = this.population,
        )

    private fun CityDto.toEntity(country: CountryEntity): CityEntity =
        CityEntity(
            id = 0,
            name = this.name,
            country = country,
        )
}