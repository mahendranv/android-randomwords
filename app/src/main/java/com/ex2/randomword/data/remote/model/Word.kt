package com.ex2.randomword.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Word(
    @Json(name = "definition")
    val definition: String,
    @Json(name = "pronunciation")
    val pronunciation: String,
    @Json(name = "word")
    val word: String
)