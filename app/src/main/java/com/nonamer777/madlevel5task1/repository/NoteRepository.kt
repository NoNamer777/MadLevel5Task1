package com.nonamer777.madlevel5task1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.nonamer777.madlevel5task1.dao.NoteDao
import com.nonamer777.madlevel5task1.database.NotepadDatabase
import com.nonamer777.madlevel5task1.model.Note

class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val database = NotepadDatabase.getDatabase(context)

        noteDao = database!!.noteDao()
    }

    fun getNote(): LiveData<Note?> = noteDao.getNote()

    suspend fun saveNote(note: Note) = noteDao.saveNote(note)

    suspend fun updateNote(note: Note) = noteDao.updateNote(note)
}
