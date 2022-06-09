package ru.mironov.showrandomcoordinatesonmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mironov.showrandomcoordinatesonmap.ui.main.GenService
import ru.mironov.showrandomcoordinatesonmap.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
            startGen()
        }
    }

     fun startGen() {
        startService(Intent(this,
            GenService::class.java))
    }
}