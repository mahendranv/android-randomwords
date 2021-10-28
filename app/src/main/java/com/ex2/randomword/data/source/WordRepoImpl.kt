package com.ex2.randomword.data.source

import android.annotation.SuppressLint
import com.ex2.randomword.data.local.AppDatabase
import com.ex2.randomword.data.remote.WordRemoteApi
import com.ex2.randomword.domain.model.Word
import com.ex2.randomword.domain.source.WordRepo
import com.ex2.randomword.data.local.model.Word as DbWord
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class WordRepoImpl(
    private val db: AppDatabase,
    private val remote: WordRemoteApi,
    private val ioDispatcher: CoroutineDispatcher
) : WordRepo {

    private val wordDao = db.wordDao()

    @SuppressLint("DefaultLocale")
    override suspend fun getWord(): Word? = withContext(ioDispatcher) {
        val response = remote.getWords()
        val result: DbWord? = if (response.isSuccessful && !response.body().isNullOrEmpty()) {
            val words = response.body()!!.map {
                DbWord(
                    id = it.word.lowercase(),
                    word = it.word,
                    definition = it.definition,
                    pronunciation = it.pronunciation
                )
            }
            // cache values
            wordDao.bulkInsert(words)
            words.firstOrNull()
        } else {
            wordDao.randomWord()
        }

        if (result == null) {
            null
        } else {
            Word(
                id = result.id,
                definition = result.definition,
                pronunciation = result.pronunciation,
                word = result.word
            )
        }
    }
}