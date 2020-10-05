package com.nonamer777.madlevel5task1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Note")
data class Note(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "last_updated")
    var lastUpdated: Date,

    @ColumnInfo(name = "body")
    var body: String,

    @PrimaryKey
    @ColumnInfo(name = "id")
    private val id: Long? = null
)
