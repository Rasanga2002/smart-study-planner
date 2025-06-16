package com.example.studyplannernew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class CreatePlan : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_plan)

        // Set up window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button1 =findViewById<Button>(R.id.btn_savePlan)
        button1.setOnClickListener {
            val intent= Intent(this, Home::class.java)
            startActivity(intent)}

        // Initialize drawer layout and navigation view
        drawerLayout = findViewById(R.id.main)
        navigationView = findViewById(R.id.navigationView)

        // Setup hamburger menu to open side navigation
        findViewById<ImageView>(R.id.hamburgerMenuIcon).setOnClickListener {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView)
            } else {
                drawerLayout.openDrawer(navigationView)
            }
        }

        // Setup side navigation item click listeners
        setupSideNavigation()

        // Setup bottom navigation
        setupBottomNavigation()

        // Find Cancel button and set click listener
        val cancelButton = findViewById<Button>(R.id.btn_cancelPlan)
        cancelButton.setOnClickListener {
            // Navigate to Home activity when Cancel is clicked
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish() // Optional: Close the current activity
        }
    }

    private fun setupSideNavigation() {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Close the drawer after selection
            drawerLayout.closeDrawers()

            // Handle navigation item selection
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
                    // Implement logout functionality
                    // For example, clear session and navigate to login screen
                    startActivity(Intent(this, SignUp::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
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

        // Settings Navigation
        findViewById<ImageView>(R.id.imageProfile).setOnClickListener {
            startActivity(Intent(this, Settings::class.java))
        }
    }
}