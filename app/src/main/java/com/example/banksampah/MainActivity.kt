package com.example.banksampah

import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.banksampah.fragments.CalculatorFragment
import com.example.banksampah.fragments.ProfileFragment
import com.example.banksampah.fragments.SampahFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNav)

        val calculatorFragment = CalculatorFragment()
        val sampahFragment = SampahFragment()
        val profileFragment = ProfileFragment()
        makeCurrentFragment(calculatorFragment)

        bottomNavigationView.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.ic_home -> makeCurrentFragment(calculatorFragment)
                R.id.ic_home1 -> makeCurrentFragment(sampahFragment)
                R.id.ic_home2 -> makeCurrentFragment(profileFragment)
            }
            true
        }


    }



    private fun makeCurrentFragment(fragment: Fragment) =

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

    }






