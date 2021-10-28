package com.ex2.randomword.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ex2.randomword.data.local.model.Word

@Database(entities = [Word::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
}