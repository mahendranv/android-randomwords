package com.ex2.randomword

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ex2.randomword.ui.WordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: WordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchWord()
        observeData()

        findViewById<View>(R.id.randomFab)
            .setOnClickListener {
                viewModel.fetchWord()
            }
    }

    private fun observeData() {
        viewModel.wordLiveData.observe(this) {
            println("##### MainActivity.observeData $it")
            findViewById<TextView>(R.id.wordLabel)
                .text = it.word
            findViewById<TextView>(R.id.definitionLabel)
                .text = it.definition
        }
    }
}