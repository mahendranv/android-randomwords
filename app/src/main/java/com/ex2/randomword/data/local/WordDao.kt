package com.ex2.randomword.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ex2.randomword.data.local.model.Word

@Dao
interface WordDao {

    @Query("select * from words")
    suspend fun getWords(): List<Word>

    @Query("select * from words order by random() limit 1")
    suspend fun randomWord(): Word

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: Word)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun bulkInsert(word: List<Word>)
}