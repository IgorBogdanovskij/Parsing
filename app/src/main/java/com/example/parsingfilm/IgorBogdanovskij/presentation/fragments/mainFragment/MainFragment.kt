package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.retrofit.ApiRetrofitWish
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.retrofit.RetrofitClient
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await

class MainFragment(): Fragment(R.layout.fragment_main) {
    lateinit var mViewMain:ViewMain


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val viewModel = ViewModelProviders.of(this).get(ViewModelMainFragment::class.java)
        mViewMain = ViewMain(activity = requireActivity(), view = view, context = view.context, object:ViewMain.CallBack{



            override fun onClickAdapter(new: News) {
                activity?.findViewById<BottomNavigationView>(R.id.navigationBottom)?.visibility=View.GONE
                val a = MainFragmentDirections.actionMainFragmentToViewNewsFragment(new)
                findNavController().navigate(a)
            }





        })

        viewModel.getNews().observe(viewLifecycleOwner){
            GlobalScope.launch(Dispatchers.Main) {
                Log.d("my", "onViewCreated NEws: ${it.size}")

                mViewMain.setDataNews(it)
            }
        }

    }


 }