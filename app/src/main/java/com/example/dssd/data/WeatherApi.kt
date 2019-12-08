package com.example.dssd.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    companion object {
        const val API_URL = "https://api.openweathermap.org/data/2.5/"
        const val API_KEY = "93600d611755886e9900b572db103cad"
    }
    @GET("weather?APPID=$API_KEY&units=metric")
    fun getCurrentWeatherForCity(@Query("q") cityAndCountryCode: String) : Call<Weather>

}