package ru.mironov.showrandomcoordinatesonmap

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.*
import kotlin.random.Random


class CoordinatesGeneratorTest() {

    @Test
    fun test() {
        // Тут сгенерировать лист из 100 пар, например и проверить, что все координаты в верных границах
        // Тест сам по себе бесполезный, но для тренировки норм
        val checkList = mutableListOf(listOf(randomPairGenerator()))
        val clearMuteList: MutableList<List<Pair<Double, Double>>> = mutableListOf()

        repeat(99) {
            clearMuteList.add((listOf(randomPairGenerator())))
        }
        assertEquals(checkList, clearMuteList)
    }

    fun randomPairGenerator(): Pair<Double, Double> {
        //расчет широты
        val randLatValue: Double = Random.nextDouble(-90.0, 90.1)
        val randLatValueRounded = String.format(Locale.US, "%.4f", randLatValue)
        val lat = randLatValueRounded.toDouble()
        //расчет долготы
        val randLonValue: Double = Random.nextDouble(-180.0, 180.1)
        val randLonValueRounded = String.format(Locale.US, "%.4f", randLonValue)
        val lon = randLonValueRounded.toDouble()
        //Возвращает пару широты/долготы в формате (0.0000, 0.0000)
        return Pair(lat, lon)
    }
}






