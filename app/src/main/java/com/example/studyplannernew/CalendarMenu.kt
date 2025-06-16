package com.example.studyplannernew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class CalendarMenu : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendar_menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initialize DrawerLayout and NavigationView
        drawerLayout = findViewById(R.id.main)
        navigationView = findViewById(R.id.navigationView)

        // Hamburger Menu Icon to Open Drawer
        findViewById<ImageView>(R.id.hamburgerMenuIcon).setOnClickListener {
            drawerLayout.open()
        }


        // Side Navigation Setup
        setupSideNavigation()

    }
    private fun setupSideNavigation() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Close the drawer when an item is selected
            drawerLayout.close()

            // Handle navigation menu item clicks
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, Home::class.java))
                    true
                }
                R.id.nav_study_plans -> {
                    startActivity(Intent(this, Plans::class.java))
                    true
                }
                R.id.nav_progress -> {
                    startActivity(Intent(this, Progress::class.java))
                    true
                }
                R.id.nav_calendar -> {
                    startActivity(Intent(this, CalendarMenu::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, Profile::class.java))
                    true
                }
                R.id.nav_settings -> {
                    startActivity(Intent(this, Settings::class.java))
                    true
                }
                R.id.nav_help -> {
                    startActivity(Intent(this, HelpSupport::class.java))
                    true
                }
                R.id.nav_logout -> {
                    // Typically would involve clearing user session and returning to login
                    startActivity(Intent(this, LogOut::class.java))
                    finish() // Close current activity
                    true
                }
                else -> false
            }
        }
    }
}