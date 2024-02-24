package ru.barsky.entity

import jakarta.persistence.*

@Entity
@Table(name = "country")
class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    val name: String = "",
    val population: Int = 0,
)
