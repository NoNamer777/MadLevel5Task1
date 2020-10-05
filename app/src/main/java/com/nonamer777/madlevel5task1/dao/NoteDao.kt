package com.nonamer777.madlevel5task1.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nonamer777.madlevel5task1.model.Note

@Dao
interface NoteDao {

    @Query("select * from Note limit 1")
    fun getNote(): LiveData<Note?>

    @Insert
    suspend fun saveNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)
}
