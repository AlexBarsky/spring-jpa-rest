package ru.barsky.exception

data class ApiError(
    val errorCode: String,
    val description: String,
)
