package com.nonamer777.madlevel5task1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nonamer777.madlevel5task1.dao.NoteDao
import com.nonamer777.madlevel5task1.model.Converters
import com.nonamer777.madlevel5task1.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@TypeConverters(Converters::class)
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotepadDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        private const val DATABASE_NAME = "NOTEPAD_DATABASE"

        @Volatile
        private var INSTANCE: NotepadDatabase? = null

        fun getDatabase(context: Context): NotepadDatabase? {

            if (INSTANCE == null) {

                synchronized(NotepadDatabase::class.java) {

                    if (INSTANCE == null) {

                        INSTANCE = Room
                            .databaseBuilder(
                                context.applicationContext,
                                NotepadDatabase::class.java,
                                DATABASE_NAME
                            )
                            .fallbackToDestructiveMigration()
                            .addCallback(object: RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)

                                    INSTANCE?.let { database -> CoroutineScope(Dispatchers.IO).launch {
                                        database.noteDao().saveNote(Note("Title", Date(), ""))
                                    }}
                                }
                            })
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

}
