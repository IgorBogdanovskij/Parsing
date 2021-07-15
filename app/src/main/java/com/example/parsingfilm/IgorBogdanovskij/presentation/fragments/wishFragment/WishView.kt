package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.wishFragment

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.parsingfilm.IgorBogdanovskij.data.models.Wish
import com.example.parsingfilm.R


class WishView(private val view:View, private val callback:Callback) {

    interface Callback{
        fun onShareClick(wish:Wish)
    }
    private val mToolbar:Toolbar = view.findViewById(R.id.toolbarWish)
    val mTextView:TextView = view.findViewById(R.id.wishTextView)
    var oneWish: Wish?= null
    init {






        mToolbar.setOnMenuItemClickListener {

            if (it.itemId == R.id.shareItem){
                callback.onShareClick(oneWish!!)
            }
            true
        }
    }


    fun setWish(wish:Wish){
        oneWish = wish
        mTextView.text = wish.quote.body
    }




}