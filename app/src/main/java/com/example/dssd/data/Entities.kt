package com.example.dssd.data

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Weather(
    val id: Int,
    val name:String,
    val main:WeatherMain,
    val weather:List<WeatherData>
)

data class WeatherData(
    val id: Int,
    val main:String,
    val description:String,
    val icon:String
)

@Entity
data class WeatherMain(
    @PrimaryKey val id: Int = currentId,
    val temp:Double,
    val pressure:Int,
    val humidity:Int
){
    companion object{
        var currentId = 0
    }
    init{
        currentId++
    }
}