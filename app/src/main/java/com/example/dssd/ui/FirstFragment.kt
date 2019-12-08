package com.example.dssd.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dssd.R
import com.example.dssd.data.Weather
import com.example.dssd.data.WeatherRepository
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class FirstFragment(
    override val coroutineContext: CoroutineContext = Dispatchers.Main
) : Fragment(),CoroutineScope {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    companion object {
        const val CITY ="city"
        const val WEATHER_OVERALL="overall"
        const val WEATHER_DESCRIPTION="description"
        const val HUMIDITY="humidity"
        const val TEMP="temperature"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = WeatherRepository()


        press.setOnClickListener {
            launch {
                if (cityName.text.isNotBlank() && countryCode.text.isNotBlank()) {
                    press.visibility=View.INVISIBLE
                    loader.visibility=View.VISIBLE
                    val cityName = cityName.text.toString()
                    val countryCode = countryCode.text.toString()
                    val weatherResponse = repository.getCurrentWeatherForCity(cityName, countryCode).await()
                    Log.i("FirstFragment", weatherResponse?.toString() ?: "Empty response")
                    weatherResponse?.apply{
                        val weatherFragment=SecondFrragment()
                        val data= Bundle().let{
                        it.putString(CITY,name)
                        it.putString(WEATHER_OVERALL,weather.first().main)
                        it.putString(WEATHER_DESCRIPTION,weather.first().descprition)
                        it.putInt(HUMIDITY,main.humidity)
                        it.putDouble(TEMP,main.temp)
                        it
                    }
                        weatherFragment.arguments = data
                        fragmentManager?.beginTransaction()
                            ?.add(R.id.container, weatherFragment)
                            ?.addToBackStack(null)
                            ?.commit()
                    }
                    press.visibility=View.VISIBLE
                    loader.visibility-View.INVISIBLE
                }
            }
        }
    }
}