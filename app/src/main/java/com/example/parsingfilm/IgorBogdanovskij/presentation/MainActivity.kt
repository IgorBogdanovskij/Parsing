package com.example.parsingfilm.IgorBogdanovskij.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController

import com.example.parsingfilm.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var mBottomNavigationView:BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mBottomNavigationView = findViewById(R.id.navigationBottom)

        mBottomNavigationView.setOnNavigationItemSelectedListener{
            if (it.itemId == R.id.news) {
                Toast.makeText(application, "Wok", Toast.LENGTH_SHORT).show()
                if (findNavController(R.id.fragment).currentDestination?.id == R.id.mainFragment){
                    return@setOnNavigationItemSelectedListener false
                }else{
                    findNavController(R.id.fragment).navigate(R.id.action_wishFragment_to_mainFragment)
                    return@setOnNavigationItemSelectedListener true

                }

            } else if (it.itemId == R.id.wishes) {
                if (findNavController(R.id.fragment).currentDestination?.id == R.id.wishFragment){
                    return@setOnNavigationItemSelectedListener false
                }else{
                    findNavController(R.id.fragment).navigate(R.id.action_mainFragment_to_wishFragment)
                    return@setOnNavigationItemSelectedListener true

                }
            }
            return@setOnNavigationItemSelectedListener false

        }
    }

}