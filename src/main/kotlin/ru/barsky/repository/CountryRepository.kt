package ru.barsky.repository

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import ru.barsky.entity.CountryEntity
import ru.barsky.model.NameOnly

interface CountryRepository : CrudRepository<CountryEntity, Int> {

    fun findByOrderByName(pageable: Pageable): List<CountryEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix: String): List<CountryEntity>

    fun findAllByOrderByName(): List<NameOnly>
}