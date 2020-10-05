package com.nonamer777.madlevel5task1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nonamer777.madlevel5task1.R
import com.nonamer777.madlevel5task1.model.NoteViewModel
import kotlinx.android.synthetic.main.fragment_add_note.*

/**
 * A simple [Fragment] subclass where a User can manipulate a Note.
 */
class AddNoteFragment : Fragment() {

    /** The view model for Notes. */
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_add_note, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handles click actions on the save button.
        btnSaveNote.setOnClickListener { saveNote() }

        observeNote()
    }

    /** Sets up Notepad observers. */
    private fun observeNote() {
        // Fills the input fields with the data from the Note.
        viewModel.note.observe(viewLifecycleOwner, { note -> note?.let {
            inputNoteTitle.editText?.setText(it.title)
            inputNoteBody.editText?.setText(it.body)
        }})

        // Shows an Error when the Note Title has been emptied.
        viewModel.error.observe(viewLifecycleOwner, { message ->
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        })

        // Navigates back on a successful update.
        viewModel.success.observe(viewLifecycleOwner, {
                success -> findNavController().popBackStack()
        })
    }

    /** Requests the Notepad to be updated. */
    private fun saveNote() = viewModel.updateNote(
        inputNoteTitle.editText?.text.toString(),
        inputNoteBody.editText?.text.toString()
    )

}
