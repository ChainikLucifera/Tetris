package com.example.tetris

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tetris.databinding.ActivityGameBinding
import com.example.tetris.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {
    private var appPreferences: AppPreferences? = null
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        appPreferences = AppPreferences(this)


        updateHighScore()
        updateCurrentScore()
    }

    private fun updateHighScore(){
        binding.tvHighScore.text = appPreferences?.getHighScore().toString()
    }
    private fun updateCurrentScore(){
        binding.tvCurrentScore.text = "0"
    }
}