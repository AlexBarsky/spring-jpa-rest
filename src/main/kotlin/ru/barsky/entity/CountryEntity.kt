package ru.barsky.entity

import jakarta.persistence.*

@Entity
@Table(name = "country")
class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var name: String = "",
    var population: Int = 0,
)
