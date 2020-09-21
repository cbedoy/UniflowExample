package com.example.stateexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stateexample.ui.fragment.BeerFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val fragment: BeerFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}