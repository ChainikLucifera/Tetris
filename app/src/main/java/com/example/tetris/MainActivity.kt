package com.example.tetris

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tetris.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences: AppPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        preferences = AppPreferences(this)
        setContentView(binding.root)

        with(binding){
            btnExit.setOnClickListener{
                finish()
            }
            btnNewGame.setOnClickListener{
                val intent: Intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
            }
            btnResetScore.setOnClickListener{
                preferences.clearHighScore()
                Snackbar.make(binding.root, "Score was successfully reset", Snackbar.LENGTH_SHORT).show()
            }
            tvHighScore.text = "Highest Score: ${preferences.getHighScore().toString()}"

        }
    }
}