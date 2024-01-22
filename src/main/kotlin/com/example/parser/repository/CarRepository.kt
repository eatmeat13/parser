package com.example.parser.repository

import com.example.parser.entity.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.math.BigInteger
import java.util.UUID

@Repository
interface CarRepository: JpaRepository<Car, UUID> {

    @Query(
        """
            select avg(price) from car
        """,
        nativeQuery = true,
    )
    fun avgPrice(): BigInteger?

    @Query(
        """
            select max(price) from car
        """,
        nativeQuery = true,
    )
    fun findMaxPrice(): BigInteger?

    @Query(
        """
            select min(price) from car
        """,
        nativeQuery = true,
    )
    fun findMinPrice(): BigInteger?

    @Query(
        """
            select avg(year) from car
        """,
        nativeQuery = true,
    )
    fun oldestCar(): BigInteger?


    @Query(
        """
            select avg(year) from car
        """,
        nativeQuery = true,
    )
    fun avgYears(): BigInteger?
}

