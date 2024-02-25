package ru.barsky.exception

import org.springframework.http.HttpStatus

class CountryNotFoundException( countryId: Long ): BaseException(
    HttpStatus.NOT_FOUND,
    ApiError(
        errorCode = "COUNTRY_NOT_FOUND",
        description = "Country with id=$countryId not found"
    )
) {
}