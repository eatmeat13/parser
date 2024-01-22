package com.example.parser.service

import com.example.parser.entity.Car
import com.example.parser.repository.CarRepository
import org.springframework.stereotype.Service

@Service
class CarService(
    private val carRepository: CarRepository,
) {

    fun saveAll(cars: Set<Car>) {
        carRepository.saveAll(cars)
    }

    fun avgPrice() =
        carRepository.avgPrice()

    fun maxPrice() =
        carRepository.findMaxPrice()

    fun minPrice() =
        carRepository.findMinPrice()

    fun oldestCar() =
        carRepository.oldestCar()

    fun avgYear() =
        carRepository.avgYears()
}