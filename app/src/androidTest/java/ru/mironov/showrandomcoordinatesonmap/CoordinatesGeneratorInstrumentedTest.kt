package ru.mironov.showrandomcoordinatesonmap

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.mironov.showrandomcoordinatesonmap.ui.main.model.CoordinatesGenerator


@RunWith(AndroidJUnit4::class)
class CoordinatesGeneratorInstrumentedTest {

    private val generator = CoordinatesGenerator()


    //Нужно для моментального выполенния post для livedata в одном потоке, чтобы не ждать, пока данные придут
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun testCoordinatesTimerGenerator() {
        //нужно сделать, чтобы этот тост проходился
        val coordinates = MutableLiveData<List<Pair<Double, Double>>>()

        val duration = 5000L
        val delay = 1000L
        val count = (duration/delay).toInt()

        generator.getCoordinatesWithTimer(delay , duration, coordinates)

        assert(coordinates.value?.size == count)
    }
}