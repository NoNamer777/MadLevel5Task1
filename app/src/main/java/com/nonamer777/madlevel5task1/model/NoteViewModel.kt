package com.nonamer777.madlevel5task1.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nonamer777.madlevel5task1.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class NoteViewModel(application: Application): AndroidViewModel(application) {

    /** The Note Repository from which data is send to and received from. */
    private val noteRepo = NoteRepository(application.applicationContext)

    /** An asynchronous scope in which mostly requests to the Note Repository are handled. */
    private val mainScope = CoroutineScope(Dispatchers.Main)

    /** The Note that is to be edited. */
    val note = noteRepo.getNote()

    /** An Error that could occur while updating a Note. */
    val error = MutableLiveData<String>()

    /** If updating a note is successful. */
    val success = MutableLiveData<Boolean>()

    /** Handles updating a Note. */
    fun updateNote(title: String, body: String) {
        // Create a new Note object with the received data.
        val newNote = Note(
            id = note.value?.id,
            title = title,
            lastUpdated = Date(),
            body = body
        )

        // Handle updating the Note.
        if (isNoteValid(newNote)) {
            mainScope.launch {
                withContext(Dispatchers.IO) { noteRepo.updateNote(newNote) }

                success.value = true
            }
        }
    }

    /** Checks if the Note still has a title. */
    private fun isNoteValid(note: Note): Boolean = when {
        note.title.isBlank() -> {
            error.value = "Title must be provided."
            false
        }
        else -> true
    }
}
