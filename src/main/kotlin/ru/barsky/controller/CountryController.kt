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
    fun getCountryById(@PathVariable("id") id: Int): CountryDto = countryService.getCountryById(id)

    @GetMapping("/search")
    fun searchCountries(@RequestParam("prefix") prefix: String): List<CountryDto> = countryService.search(prefix)

    @GetMapping("/names")
    fun getAllCountryNames(): List<String> = countryService.getAllCountryNames()

    @PostMapping
    fun createCountry(@RequestBody countryDto: CountryDto): Int {
        return countryService.createCountry(countryDto)
    }

    @PutMapping("/{id}")
    fun updateCountry(@PathVariable("id") id: Int, @RequestBody countryDto: CountryDto) {
        countryService.updateCountry(id, countryDto)
    }

    @DeleteMapping("/{id}")
    fun deleteCountry(@PathVariable("id") id: Int) {
        countryService.deleteCountry(id)
    }
}