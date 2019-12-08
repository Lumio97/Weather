package com.example.dssd.data

data class Weather(
    val name:String,
    val main:WeatherMain,
    val weather:List<WeatherData>
)

data class WeatherData(
    val main:String,
    val descprition:String,
    val icon:String
)

data class WeatherMain(
    val temp:Double,
    val pressure:Int,
    val humidity:Int
)