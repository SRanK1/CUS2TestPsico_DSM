package com.example.testpsico

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import com.example.testpsico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnZung?.setOnClickListener {
            startGame("easy")
        }
        binding?.btnBeck?.setOnClickListener {
            startGame("medium")
        }
    }

    private fun startGame(questionType:String)
    {
        val intent = Intent(this,PlayActivity::class.java)
        intent.putExtra("questionType",questionType)
        startActivity(intent)
    }
}