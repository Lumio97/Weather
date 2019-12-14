package com.example.dssd.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dssd.R
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.fragment_weather.cityTitle

class SecondFrragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_weather, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weather = arguments?.getString(FirstFragment.WEATHER_OVERALL)

        cityTitle.text =arguments?.getString(FirstFragment.CITY)
        title.text=arguments?.getString(FirstFragment.WEATHER_OVERALL)
        description.text=arguments?.getString(FirstFragment.WEATHER_DESCRIPTION)
        temperature.text="${arguments?.getDouble(FirstFragment.TEMP)}°C"
        humidity.text="${arguments?.getInt(FirstFragment.HUMIDITY)}%"

       val drawable = resources.getDrawable(when(weather) {
            "Clear" -> R.drawable.clear
            "Snow" -> R.drawable.snow
            "Rain"-> R.drawable.rain
            else -> R.drawable.def

        })
        background_picture.setImageDrawable(drawable)
    }

}