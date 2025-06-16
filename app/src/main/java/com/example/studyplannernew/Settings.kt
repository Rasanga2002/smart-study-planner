package com.example.studyplannernew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationView

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)

        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize drawer and navigation view
        val drawerLayout = findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.main)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

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
                R.id.nav_study_plans -> startActivity(Intent(this, Plans::class.java))
                R.id.nav_progress -> startActivity(Intent(this, Progress::class.java))
                R.id.nav_calendar -> startActivity(Intent(this, CalendarMenu::class.java))
                R.id.nav_profile -> startActivity(Intent(this, Profile::class.java))
                R.id.nav_settings -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_help -> startActivity(Intent(this, HelpSupport::class.java))
                R.id.nav_logout -> startActivity(Intent(this, LogOut::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Profile Settings Navigation
        findViewById<LinearLayout>(R.id.editProfileLayout).setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }

        findViewById<LinearLayout>(R.id.changePasswordLayout).setOnClickListener {
            // Placeholder for change password functionality
        }

        // Help and Support Navigation
        findViewById<LinearLayout>(R.id.contactSupportLayout).setOnClickListener {
            startActivity(Intent(this, HelpSupport::class.java))
        }

        findViewById<LinearLayout>(R.id.privacyPolicyLayout).setOnClickListener {
            // Placeholder for privacy policy
        }

        // Bottom Navigation
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        // Home Navigation
        findViewById<ImageView>(R.id.imageHome).setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        // Calendar Navigation
        findViewById<ImageView>(R.id.imageCalendar).setOnClickListener {
            startActivity(Intent(this, Plans::class.java))
        }

        // Progress Navigation
        findViewById<ImageView>(R.id.imageAdd).setOnClickListener {
            startActivity(Intent(this, Progress::class.java))
        }

        // Profile Navigation
        findViewById<ImageView>(R.id.imageInformation).setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
        }

        // Settings Navigation
        findViewById<ImageView>(R.id.imageProfile).setOnClickListener {
            // Current page, do nothing
        }
    }
}