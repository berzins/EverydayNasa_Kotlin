package com.ligagriezne.nasaeveryday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ligagriezne.nasaeveryday.Fragments.FavoriteFragment
import com.ligagriezne.nasaeveryday.Fragments.HistoryFragment
import com.ligagriezne.nasaeveryday.Fragments.TodayFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val favoriteFragment = FavoriteFragment.newInstance("", "")
        val historyFragment = HistoryFragment.newInstance("", "")
        val todayFragment = TodayFragment.newInstance("", "")

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.today -> makeCurrentFragment(todayFragment)
                R.id.history -> makeCurrentFragment(historyFragment)
                R.id.favorite -> makeCurrentFragment(favoriteFragment)
            }
            true
        }

        makeCurrentFragment(todayFragment)
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }

}