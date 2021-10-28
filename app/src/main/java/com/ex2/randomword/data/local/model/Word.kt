package com.ex2.randomword.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "word")
    val word: String,

    @ColumnInfo(name = "definition")
    val definition: String,

    @ColumnInfo(name = "name")
    val pronunciation: String
)
