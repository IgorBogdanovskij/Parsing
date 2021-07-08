package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.content.Context
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.retrofit.ApiRetrofitWish
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.retrofit.RetrofitClient
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.await

class ViewMain(val activity: FragmentActivity, val view: View, val context: Context, private val callback: CallBack) {

    interface CallBack {
        fun onClickAdapter(new:News)

    }


    private val mToolbar: Toolbar = view.findViewById(R.id.toolbarNews)
    private var mRecyclerView:RecyclerView
    private var mAdapter:AdapterViewHolder



        init {
            activity?.findViewById<BottomNavigationView>(R.id.navigationBottom)?.visibility=View.VISIBLE

        mRecyclerView = view.findViewById(R.id.recyclerViewMain)


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