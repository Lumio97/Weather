package com.example.dssd.data

import android.util.Log
import com.example.dssd.WeatherApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class WeatherRepository (
    override val  coroutineContext : CoroutineContext = Dispatchers.IO
) : CoroutineScope {
    private var api = Retrofit.Builder()
        .baseUrl(WeatherApi.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi ::class.java)


    fun getCurrentWeatherForCity(city:String,countryCode:String) = async {
        val weather = api.getCurrentWeatherForCity("$city,$countryCode")
            .execute()
            .body()
        WeatherApp.db
            .weatherMainDao()
            .insertAll(weather!!.main)
        Log.i("DbTest",WeatherApp.db
            .weatherMainDao()
                .getAllWeatherMain()
            .toString())
        weather

    }
}