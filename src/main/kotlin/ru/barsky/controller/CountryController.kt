package ru.barsky.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.barsky.dto.CountryDto
import ru.barsky.service.CountryService

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: CountryService,
) {

    @GetMapping
    fun getAllCountries(@RequestParam("page") pageIndex: Int): List<CountryDto> = countryService.getAllCountries(pageIndex)
}