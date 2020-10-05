package com.nonamer777.madlevel5task1.model

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun fromLongToTimestamp(value: Long?): Date? = value?.let { Date(it) }

    @TypeConverter
    fun fromTimestampToLong(date: Date?): Long? = date?.time?.toLong()
}
