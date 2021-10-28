package com.ex2.randomword.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.randomword.domain.model.Word
import com.ex2.randomword.domain.source.WordRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    private val repo: WordRepo
) : ViewModel() {

    private val _wordLiveData = MutableLiveData<Word>()
    val wordLiveData: LiveData<Word> = _wordLiveData

    fun fetchWord() = viewModelScope.launch {
        val word = repo.getWord()
        word?.let {
            _wordLiveData.value = it
        }
    }
}