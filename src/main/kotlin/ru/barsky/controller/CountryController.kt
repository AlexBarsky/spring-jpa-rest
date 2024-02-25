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

    @GetMapping("/search")
    fun searchCountries(@RequestParam("prefix") prefix: String): List<CountryDto> = countryService.search(prefix)

    @PostMapping
    fun createCountry(@RequestBody countryDto: CountryDto): Long {
        return countryService.createCountry(countryDto)
    }

    @PutMapping("/{id}")
    fun updateCountry(@PathVariable("id") id: Long, @RequestBody countryDto: CountryDto) {
        countryService.updateCountry(id, countryDto)
    }

    @DeleteMapping("/{id}")
    fun deleteCountry(@PathVariable("id") id: Long) {
        countryService.deleteCountry(id)
    }
}