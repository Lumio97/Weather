package com.example.dssd.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert
    fun insertAll(vararg weatherMain: WeatherMain)


        @Query("SELECT * FROM weathermain")
        fun getAllWeatherMain():List<WeatherMain>


}