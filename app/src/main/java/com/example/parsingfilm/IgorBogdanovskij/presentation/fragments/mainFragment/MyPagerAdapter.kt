package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.wishFragment.WishFragment

class MyPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MainFragment()
            else -> WishFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"NEWS"
            else -> "WISHES"
        }
    }
}