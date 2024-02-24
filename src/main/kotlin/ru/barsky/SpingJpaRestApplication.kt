package ru.barsky

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpingJpaRestApplication

fun main(args: Array<String>) {
    runApplication<SpingJpaRestApplication>(*args)
}
