package com.example.parsingfilm.IgorBogdanovskij.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment.MyPagerAdapter

import com.example.parsingfilm.R
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val mViewPager:ViewPager = findViewById(R.id.mypager)
//        val myPagerAdapter = MyPagerAdapter(supportFragmentManager)
//        mViewPager.adapter = myPagerAdapter
//        val mTabView = findViewById<TabLayout>(R.id.tabLayout)
//        mTabView.setupWithViewPager(mViewPager)
    }

}