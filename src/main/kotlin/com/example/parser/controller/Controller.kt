package com.example.parser.controller

import com.example.parser.service.CarService
import com.example.parser.service.ParserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger


@RestController
class Controller(
    private val parserService: ParserService,
    private val carService: CarService,
) {

    @GetMapping("/hello")
    fun hello(): String =
        "Это парсер drom.ru!"

    @PostMapping("/parse")
    fun parse(): String =
        parserService.parseAllPages(
            baseURL = "https://auto.drom.ru/",
            totalPages = 45,
        ).toString()

    @PostMapping("/analyse/avgPrice")
    fun avgPrice(): BigInteger? {
        return carService.avgPrice()
    }

    @PostMapping("/analyse/maxPrice")
    fun maxPrice(): BigInteger? {
        return carService.maxPrice()
    }

    @PostMapping("/analyse/minPrice")
    fun minPrice(): BigInteger? {
        return carService.minPrice()
    }

    @PostMapping("/analyse/avgYear")
    fun avgYear(): BigInteger? {
        return carService.avgYear()
    }
    @PostMapping("/analyse/oldestCar")
    fun oldestCar(): BigInteger? {
        return carService.oldestCar()
    }
}