package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.wishFragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.parsingfilm.IgorBogdanovskij.data.models.Wish
import com.example.parsingfilm.R

class WishFragment:Fragment(R.layout.wish_layout) {


    lateinit var mWishView:WishView
    lateinit var viewModel:WishViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProviders.of(this).get(WishViewModel::class.java)
        mWishView = WishView(view, object:WishView.Callback{
            override fun onShareClick(wish: Wish) {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT,wish.quote.body )
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(intent, "Share"))
            }


        })
            viewModel.getOneNew().observe(viewLifecycleOwner){

                mWishView.mTextView.text= it.quote.body
                mWishView.oneWish = it
            }
    }


}