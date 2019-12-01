package com.example.dssd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dssd.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container,FirstFragment())
            .commit()

    }
}
