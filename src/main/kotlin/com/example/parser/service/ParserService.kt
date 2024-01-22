package com.example.parser.service

import com.example.parser.entity.Car
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Service

@Service
class ParserService(
    private val carService: CarService,
) {

    fun parseAllPages(baseURL: String, totalPages: Int): List<Car> {
        val allCars = mutableListOf<Car>()

        for (page in 36..totalPages) {
            val url = "$baseURL?page=$page"
            val carsOnPage = parse(url)
            carService.saveAll(carsOnPage)
        }
        return allCars
    }

    fun parse(url: String): Set<Car> {
        val document: Document = Jsoup.connect(url)
            .userAgent("Mozilla")
            .timeout(5000)
            .referrer("https://google.com")
            .get()

        val carsPrices = document.getElementsByClass("css-1y23fm5 e12df7sj0")
        val carsNames = document.select("[data-ftid=bull_title]")

        val listOfCars = mutableSetOf<Car>()
        var index = 0
        while (index < carsNames.size && index < carsPrices.size) {
            val priceString = carsPrices[index].text().replace("\\s".toRegex(), "")
            val carNameCommaYear = carsNames[index].text().toString().split(",")
            listOfCars.add(
                Car(
                    name = carNameCommaYear[0],
                    price = priceString.substring(0, priceString.length - 1).toInt(),
                    year = carNameCommaYear[1].trim().toInt(),
                )
            )
            index++
        }
        return listOfCars
    }
}