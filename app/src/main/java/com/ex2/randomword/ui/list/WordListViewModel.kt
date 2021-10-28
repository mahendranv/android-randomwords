package com.ex2.randomword.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ex2.randomword.domain.source.WordRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordListViewModel @Inject constructor(
    private val repo: WordRepo
) : ViewModel() {

    fun fetchWords() {
        viewModelScope.launch {
            repo.getWord()
        }
    }
}