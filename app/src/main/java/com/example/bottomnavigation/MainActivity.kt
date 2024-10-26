package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        
        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        replaceWithFragment(Home())
        // by default, home fragment should be visible to the user

        bottomView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.item1 -> replaceWithFragment(Home())
                R.id.item2 -> replaceWithFragment(Search())
                R.id.item3 -> replaceWithFragment(Profile())
                else -> {

                }
            }
            true
        }
    }

    private fun replaceWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }

}