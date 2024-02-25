package ru.barsky.repository

import org.springframework.data.repository.CrudRepository
import ru.barsky.entity.CityEntity
import ru.barsky.entity.CountryEntity

interface CityRepository: CrudRepository<CityEntity, Int> {

    fun deleteAllByCountry(country: CountryEntity)
}