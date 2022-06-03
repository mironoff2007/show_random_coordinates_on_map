package ru.mironov.showrandomcoordinatesonmap.ui.main.model

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

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

    fun getCoordinatesWithTimer(
        duration: Long,
        delay: Long,
        coordinates: MutableLiveData<MutableList<Pair<Double, Double>>>,
    ) {
        val newList = mutableListOf<Pair<Double, Double>>()
            for (i in 0L..duration step 200) {
                newList.add(generateCoordinates())
                Thread.sleep(delay)
                coordinates.postValue(newList)
            }

    }
}



