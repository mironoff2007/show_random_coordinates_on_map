package ru.mironov.showrandomcoordinatesonmap.ui.main.model

import java.util.*
import kotlin.random.Random

class CoordinatesGenerator {

    fun generateCoordinates(): Pair<Double, Double> {
        //тут реализовать генератор
        //широта
        val randLatValue: Double = Random.nextDouble(-90.0, 90.1)
        val randLatValueRounded = String.format(Locale.US, "%.4f", randLatValue)
        val lat = randLatValueRounded.toDouble()
        //долгота
        val randLonValue: Double = Random.nextDouble(-180.0, 180.1)
        val randLonValueRounded = String.format(Locale.US, "%.4f", randLonValue)
        val lon = randLonValueRounded.toDouble()
        //Возвращает пару широты/долготы в формате (0.0000, 0.0000)
        return Pair(lat, lon)
    }

}