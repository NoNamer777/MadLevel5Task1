package com.nonamer777.madlevel5task1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nonamer777.madlevel5task1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
