package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.DateNews
import com.example.parsingfilm.IgorBogdanovskij.data.repository.RepositoryImp
import com.example.parsingfilm.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

open class MainFragment(): Fragment(R.layout.fragment_main) {
    lateinit var mViewMain:ViewMain

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        val viewModel = ViewModelProviders.of(this).get(ViewModelMainFragment::class.java)
        mViewMain = ViewMain(activity = requireActivity(), view = view, context = view.context, object:ViewMain.CallBack{
            override fun onClick() {
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