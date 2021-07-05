package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.content.Context
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.google.android.material.appbar.MaterialToolbar

class ViewMain(val activity: FragmentActivity, val view: View, val context: Context, private val callback: CallBack) {

    interface CallBack {
        fun onClick()
    }



    private var mButton: Button = view.findViewById(R.id.button)
    private var mToolbar: MaterialToolbar = view.findViewById(R.id.toolbarPars)
    private var mRecyclerView:RecyclerView = view.findViewById(R.id.recyclerViewMain)
    private var mAdapter = Adapter_ViewHolder()


    init {
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    fun setDataNews(list:MutableList<News>){
        mAdapter.setList(list)
    }
}