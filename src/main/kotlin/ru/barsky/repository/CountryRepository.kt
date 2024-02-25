package ru.barsky.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.barsky.entity.CountryEntity

interface CountryRepository : CrudRepository<CountryEntity, Int> {

    fun findByOrderByName(pageable: Pageable): List<CountryEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix: String): List<CountryEntity>
}