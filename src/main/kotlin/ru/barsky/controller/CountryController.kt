package ru.barsky.controller

import org.springframework.web.bind.annotation.*
import ru.barsky.dto.CountryDto
import ru.barsky.service.CountryService

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: CountryService,
) {

    @GetMapping
    fun getAllCountries(@RequestParam("page") pageIndex: Int): List<CountryDto> = countryService.getAllCountries(pageIndex)

    @GetMapping("/{id}")
    fun getCountryById(@PathVariable("id") id: Long): CountryDto = countryService.getCountryById(id)
}