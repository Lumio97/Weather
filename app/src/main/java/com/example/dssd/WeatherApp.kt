package com.example.dssd

import android.app.Application
import androidx.room.Room
import com.example.dssd.data.WeatherDatabase

class WeatherApp : Application() {
    companion object {
        lateinit var db: WeatherDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            WeatherDatabase::class.java,"weather-database"
        ).build()
    }
}