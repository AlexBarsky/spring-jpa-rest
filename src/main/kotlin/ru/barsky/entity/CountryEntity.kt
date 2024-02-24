package ru.barsky.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("country")
data class CountryEntity(
    @Id var id: Long,
    val name: String,
    val capital: String,
    val population: Int,
    val region: String,
)
