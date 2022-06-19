package ru.mironov.showrandomcoordinatesonmap

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.mironov.showrandomcoordinatesonmap.data.CoordinatesGenerator


@RunWith(AndroidJUnit4::class)
class CoordinatesGeneratorInstrumentedTest {

    private val generator = CoordinatesGenerator()


    //Нужно для моментального выполенния post для livedata в одном потоке, чтобы не ждать, пока данные придут
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Test
    fun testCoordinatesTimerGenerator() {
        val coordinates = MutableLiveData<List<Pair<Double, Double>>>()

        val duration = 2000L
        val delay = 100L
        val startTime = System.currentTimeMillis()

        val count = (duration/delay).toInt()

        //Запускает корутину, блокируя текущий поток. По сути в том же потоке.
        //Асинхронный код выпалняем синхронно
        //Нужно для тестов, вне тестов runBlocking лучше не использовать
        runBlocking {
            generator.getCoordinatesWithTimer(duration, delay, coordinates)
        }

        val endTime = System.currentTimeMillis()
        val testTime = endTime - startTime

        Log.d("Test_tag", "test time - $testTime")
        assert(coordinates.value?.size == count && testTime > duration)
    }
}