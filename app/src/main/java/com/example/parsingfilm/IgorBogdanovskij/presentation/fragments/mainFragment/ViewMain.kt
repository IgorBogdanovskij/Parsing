package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout

class ViewMain(val activity: FragmentActivity, val view: View, val context: Context, private val callback: CallBack) {

    interface CallBack {
        fun onClickAdapter(new:News)
        fun onClickTabs()
    }



    private var mToolbar: MaterialToolbar
    private var mRecyclerView:RecyclerView
    private var mAdapter:AdapterViewHolder
    private lateinit var mTabView:TabLayout
    private lateinit var mViewPager: ViewPager


    init {
        mToolbar = view.findViewById(R.id.toolbarPars)
        mRecyclerView = view.findViewById(R.id.recyclerViewMain)
        mTabView = view.findViewById(R.id.tabLayout)
       // mViewPager = view.findViewById(R.id.mypager)

//        val myPagerAdapter = MyPagerAdapter(activity.supportFragmentManager)
//        mViewPager.adapter = myPagerAdapter
//        mTabView.setupWithViewPager(mViewPager)
        mAdapter = AdapterViewHolder(object :AdapterViewHolder.CallBack{
            override fun onClick(new: News) {
                callback.onClickAdapter(new)
            }

        })

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)


    }

    fun setDataNews(list:MutableList<News>){
        mAdapter.setList(list)
    }
}