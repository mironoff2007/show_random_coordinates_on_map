package ru.mironov.showrandomcoordinatesonmap

import junit.framework.TestCase.assertEquals
import org.junit.Test
import ru.mironov.showrandomcoordinatesonmap.ui.main.model.CoordinatesGenerator
import java.util.*
import kotlin.random.Random


class CoordinatesGeneratorTest() {

    private val generator = CoordinatesGenerator()

    @Test
    fun test() {
        // Тут сгенерировать лист из 100 пар, например и проверить, что все координаты в верных границах
        // Тест сам по себе бесполезный, но для тренировки норм
        val clearMuteList: MutableList<Pair<Double, Double>> = mutableListOf()
        repeat(99) {
            clearMuteList.add(generator.generateCoordinates())
        }

        var simpleBoolean: Boolean

        val vDiapazone = clearMuteList.forEach {
            if (it.first in -90.0000..90.0001 || it.second in -180.0000..180.0001)
                simpleBoolean = true
        }
        val neVDiapazone = clearMuteList.forEach {
            if (it.first !in -90.0000..90.0001 || it.second !in -180.0000..180.0001)
                simpleBoolean = false
        }
        assertEquals(vDiapazone, neVDiapazone)
    }

}







