package com.ex2.randomword.data.remote

import com.ex2.randomword.data.remote.model.Word
import retrofit2.Response
import retrofit2.http.GET

interface WordRemoteApi {

    @GET("/word")
    suspend fun getWords(): Response<List<Word>>
}