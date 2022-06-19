package ru.mironov.showrandomcoordinatesonmap

import org.junit.Test
import ru.mironov.showrandomcoordinatesonmap.data.CoordinatesGenerator


class CoordinatesGeneratorTest() {

    private val generator = CoordinatesGenerator()

    @Test
    fun test() {
        val coordinatesList: MutableList<Pair<Double, Double>> = mutableListOf()

        repeat(99) {
            coordinatesList.add(generator.generateCoordinates())
        }

        var allAreInRange = true

        coordinatesList.forEach {
            if (it.first !in -90.0..90.0 || it.second !in -180.0..180.0) allAreInRange = false
        }

        assert(allAreInRange)
    }
}







