package ru.barsky.repository

import org.springframework.data.repository.CrudRepository
import ru.barsky.entity.CountryEntity

interface CountryRepository : CrudRepository<CountryEntity, Long>