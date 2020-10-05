package com.nonamer777.madlevel5task1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nonamer777.madlevel5task1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /** The Navigation controller of the application. */
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        navController = findNavController(R.id.nav_host_fragment)

        // Handles click actions on the fab.
        fab.setOnClickListener {
            navController.navigate(R.id.action_notepadFragment_to_addNoteFragment)
        }

        toggleFab()
    }

    /** Toggles or the fab based on the active fragment. */
    private fun toggleFab() = navController.addOnDestinationChangedListener { _, destination, _ ->
        if (destination.id in arrayOf(R.id.addNoteFragment)) fab.hide()
        else fab.show()
    }
}
