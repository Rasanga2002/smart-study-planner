package com.example.studyplannernew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Plans : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_plans)

        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize drawer and navigation view
        drawerLayout = findViewById(R.id.main)
        navigationView = findViewById(R.id.navigationView)

        // Hamburger menu toggle
        findViewById<ImageView>(R.id.hamburgerMenuIcon).setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        // Side Navigation Drawer
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> startActivity(Intent(this, Home::class.java))
                R.id.nav_study_plans -> {
                    // Current page, do nothing
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_progress -> startActivity(Intent(this, Progress::class.java))
                R.id.nav_calendar -> startActivity(Intent(this, CalendarMenu::class.java))
                R.id.nav_profile -> startActivity(Intent(this, Profile::class.java))
                R.id.nav_settings -> startActivity(Intent(this, Settings::class.java))
                R.id.nav_help -> startActivity(Intent(this, HelpSupport::class.java))
                R.id.nav_logout -> startActivity(Intent(this, LogOut::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Setup Bottom Navigation
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        // Home Navigation
        findViewById<ImageView>(R.id.imageHome).setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        // Calendar/Plans Navigation
        findViewById<ImageView>(R.id.imageCalendar).setOnClickListener {
            // Current page, do nothing
        }

        // Progress Navigation
        findViewById<ImageView>(R.id.imageAdd).setOnClickListener {
            startActivity(Intent(this, Progress::class.java))
        }

        // Settings Navigation
        findViewById<ImageView>(R.id.imageProfile).setOnClickListener {
            startActivity(Intent(this, Settings::class.java))
        }
    }
}