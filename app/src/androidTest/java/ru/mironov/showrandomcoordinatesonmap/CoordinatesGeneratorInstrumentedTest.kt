package ru.mironov.showrandomcoordinatesonmap

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
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
        //для начала в одном потоке, позже сделаем асинхронно
        val coordinates = MutableLiveData<MutableList<Pair<Double, Double>>>()

        val duration = 60000L
        val startTime = System.currentTimeMillis()
        val delay = 200L
        val endTime = System.currentTimeMillis()
        val count = (duration/delay).toInt()

        generator.getCoordinatesWithTimer(duration, delay, coordinates)

        assert(coordinates.value?.size == count)
    }
}