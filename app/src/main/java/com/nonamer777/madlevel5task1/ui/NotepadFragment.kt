package com.nonamer777.madlevel5task1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nonamer777.madlevel5task1.R
import com.nonamer777.madlevel5task1.model.NoteViewModel
import kotlinx.android.synthetic.main.fragment_notepad.*

/**
 * A simple [Fragment] subclass where a User is presented an overview of his Notes.
 */
class NotepadFragment : Fragment() {

    /** The view model for Notes. */
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notepad, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAddNoteResult()
    }

    /** Sets up an observer to update the view. */
    private fun observeAddNoteResult() {
        viewModel.note.observe(viewLifecycleOwner, Observer { note -> note?.let {
            txtLastModified.text = String.format("Last updated: %s", it.lastUpdated.toString())

            txtNoteTitle.text = it.title
            txtNoteBody.text = it.body
        }})
    }
}