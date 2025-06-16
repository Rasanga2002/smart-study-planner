package com.example.studyplannernew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.navigation.NavigationView

class NewUserHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_user_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.createPlanButton).setOnClickListener {
            startActivity(Intent(this, CreatePlan::class.java))
        }
        findViewById<Button>(R.id.addTaskButton).setOnClickListener {
            startActivity(Intent(this, AddTask::class.java))
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
                R.id.nav_home -> drawerLayout.closeDrawer(GravityCompat.START)
                R.id.nav_study_plans -> startActivity(Intent(this, Plans::class.java))
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

        // Bottom Navigation
        setupBottomNavigation()

    }

    private fun setupBottomNavigation() {
        // Home Navigation
        findViewById<ImageView>(R.id.imageHome).setOnClickListener {
            // Current page, do nothing
        }

        // Calendar Navigation
        findViewById<ImageView>(R.id.imageCalendar).setOnClickListener {
            startActivity(Intent(this, Plans::class.java))
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