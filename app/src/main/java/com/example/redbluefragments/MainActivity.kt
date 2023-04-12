package com.example.redbluefragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//Declare vars for the fragment container view and the navigation view
    private lateinit var containerView: View
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Create, instantiate the vars to the views
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        containerView = findViewById(R.id.fragment_container)

//Set up the navigation view
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.show_survey -> {
                    showFragment("SURVEY")
                    true
                }
                R.id.show_results -> {
                    showFragment("RESULTS")
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
//The function to actually show the fragment for which navigation is clicked
    private fun showFragment(tag: String) {
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            when (tag) {
                "SURVEY" -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SurveyFragment.newInstance(), "SURVEY")
                        .commit()
                }
                "RESULTS" -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ResultsFragment.newInstance(), "RESULTS")
                        .commit()
                }
            }
        }
    }
}
