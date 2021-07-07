package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.content.Context
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        fun onClickTabs()
        fun onClickNews()
        fun onClickWishes()
        fun onClickShareWish()
    }



    private var mToolbar: MaterialToolbar
    private var mWishTextView:TextView
    private var mRecyclerView:RecyclerView
    private var mAdapter:AdapterViewHolder
    private lateinit var mIncludeWish:View
    private lateinit var mBottomNavigationView: BottomNavigationView


        init {
        mWishTextView = view.findViewById(R.id.wishTextView)
        mToolbar = view.findViewById(R.id.toolbarPars)
        mRecyclerView = view.findViewById(R.id.recyclerViewMain)
        mBottomNavigationView = view.findViewById(R.id.navigation)
        mIncludeWish = view.findViewById(R.id.includeWish)


        mAdapter = AdapterViewHolder(object :AdapterViewHolder.CallBack{
            override fun onClick(new: News) {
                callback.onClickAdapter(new)
            }

        })

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)

        mBottomNavigationView.setOnNavigationItemSelectedListener{
            if (it.itemId == R.id.news) {
                mToolbar.menu.clear()
                mRecyclerView.visibility = View.VISIBLE
                mIncludeWish.visibility= View.GONE
                mToolbar.title = "News"
                callback.onClickNews()
                return@setOnNavigationItemSelectedListener true
            } else if (it.itemId == R.id.wishes) {
                mToolbar.inflateMenu(R.menu.wish_menu)
                mRecyclerView.visibility = View.GONE
                mIncludeWish.visibility = View.VISIBLE
                mToolbar.title = "Random Wish"


                getDataWish()
                callback.onClickWishes()
                return@setOnNavigationItemSelectedListener true
            }
            return@setOnNavigationItemSelectedListener false

        }

            // TODO: 07/07/2021  
        mToolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.wishes){
                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
                return@setOnMenuItemClickListener true
            }
            return@setOnMenuItemClickListener false
        }
    }

    private fun getDataWish() {

        GlobalScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.getClient().create(ApiRetrofitWish::class.java)
            val oneWish = response.getOneWish().await().quote.body

            withContext(Dispatchers.Main){
                mWishTextView.text = oneWish
            }
        }
    }


    fun setDataNews(list:MutableList<News>){
        mAdapter.setList(list)
    }
}