package ru.mironov.showrandomcoordinatesonmap.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mironov.showrandomcoordinatesonmap.data.CoordinatesGenerator

class GenService : Service() {

    private val generator = CoordinatesGenerator()

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        startGenerate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startGenerate() {
        CoroutineScope(Dispatchers.IO).launch {
            generator.generateCoordinates()
        }
    }
}