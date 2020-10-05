package com.nonamer777.madlevel5task1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nonamer777.madlevel5task1.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * A simple [Fragment] subclass where a User can manipulate a Note.
 */
class AddNoteFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_add_note, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set navigation action on the fab.
        fab.setOnClickListener {
            findNavController().navigate(R.id.action_notepadFragment_to_addNoteFragment)
        }
    }
}
