package com.ex2.randomword.domain.source

import com.ex2.randomword.domain.model.Word

interface WordRepo {

    suspend fun getWord(): Word?
}