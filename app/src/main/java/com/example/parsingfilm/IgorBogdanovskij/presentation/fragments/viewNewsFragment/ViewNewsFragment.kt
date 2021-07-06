package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.viewNewsFragment

import android.content.Context
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.squareup.picasso.Picasso

class ViewNewsFragment(context: Context, view: View, ) {

     var mDescription: TextView = view.findViewById(R.id.DescriptionView)
     var mTitle: TextView = view.findViewById(R.id.TitleView)
     var mImage: ImageView = view.findViewById(R.id.ImageViewFr)

    //var mNews:News? = null
    init {

    }


//    fun setNewsFromFragment(new:News){
//        mNews = new
//    }
}