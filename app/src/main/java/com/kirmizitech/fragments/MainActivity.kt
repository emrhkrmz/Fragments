package com.kirmizitech.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var replace: Button
    lateinit var backSpace: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replace = findViewById(R.id.buttonReplace)
        backSpace = findViewById(R.id.backSpace)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()

        fragmentTransaction.add(R.id.frame, firstFragment)

        fragmentTransaction.commit()

        replace.setOnClickListener {

            val secondFragmentManager: FragmentManager = supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction = secondFragmentManager.beginTransaction()

            val secondFragment = SecondFragment()

            secondFragmentTransaction.replace(R.id.frame,secondFragment)

            secondFragmentTransaction.commit()

        }

        backSpace.setOnClickListener {

            val firstFragmentManager: FragmentManager = supportFragmentManager
            val firstFragmentTransaction: FragmentTransaction = firstFragmentManager.beginTransaction()

            val firstFragment = FirstFragment()

            firstFragmentTransaction.replace(R.id.frame,firstFragment)

            firstFragmentTransaction.commit()

        }

    }
}