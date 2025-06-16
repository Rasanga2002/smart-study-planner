package com.example.studyplannernew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingNext : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_next)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button1 =findViewById<Button>(R.id.button3 )
        button1.setOnClickListener {
            val intent = Intent(this, OnboardingThree::class.java)
            startActivity(intent)
        }
        val button2 =findViewById<Button>(R.id.button4 )
        button2.setOnClickListener {
            val intent = Intent(this, OnboardingThree::class.java)
            startActivity(intent)
        }
        val button3 =findViewById<Button>(R.id.button5 )
        button3.setOnClickListener {
            val intent = Intent(this, OnboardingThree::class.java)
            startActivity(intent)
        }
    }
}