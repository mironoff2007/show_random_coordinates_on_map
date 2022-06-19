package ru.mironov.showrandomcoordinatesonmap.data

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import java.util.*
import kotlin.random.Random

class CoordinatesGenerator {

    fun generateCoordinates(): Pair<Double, Double> {
        //тут реализовать генератор
        //широта
        val randLatValue: Double = Random.nextDouble(-90.0, 90.0001)
        val randLatValueRounded = String.format(Locale.US, "%.4f", randLatValue)
        val lat = randLatValueRounded.toDouble()
        //долгота
        val randLonValue: Double = Random.nextDouble(-180.0, 180.0001)
        val randLonValueRounded = String.format(Locale.US, "%.4f", randLonValue)
        val lon = randLonValueRounded.toDouble()
        //Возвращает пару широты/долготы в формате (0.0000, 0.0000)
        return Pair(lat, lon)
    }

    // suspend означает, что функцию надо вызывать из корутины
    suspend fun getCoordinatesWithTimer(
        duration: Long,
        delay: Long,
        coordinates: MutableLiveData<List<Pair<Double, Double>>>,
    ) {
        val newList = mutableListOf<Pair<Double, Double>>()
            for (i in delay..duration step delay) {
                newList.add(generateCoordinates())
                delay(delay)
                coordinates.postValue(newList)
            }
    }
}



