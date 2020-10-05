package com.nonamer777.madlevel5task1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nonamer777.madlevel5task1.R
import com.nonamer777.madlevel5task1.model.Note
import com.nonamer777.madlevel5task1.model.NoteViewModel
import com.nonamer777.madlevel5task1.repository.NoteRepository
import kotlinx.android.synthetic.main.fragment_notepad.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass where a User is presented an overview of his Notes.
 */
class NotepadFragment : Fragment() {

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_notepad, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAddNoteResult()
    }

    private fun observeAddNoteResult() {
        viewModel.note.observe(viewLifecycleOwner, Observer { note -> note?.let {
            txtLastModified.text = String.format("Last updated: %s", it.lastUpdated.toString())

            txtNoteTitle.text = it.title
            txtNoteBody.text = it.body
        }})
    }
}