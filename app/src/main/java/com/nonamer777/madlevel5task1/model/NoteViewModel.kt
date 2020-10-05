package com.nonamer777.madlevel5task1.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nonamer777.madlevel5task1.repository.NoteRepository

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val noteRepo = NoteRepository(application.applicationContext)

    val note = noteRepo.getNote()

}
