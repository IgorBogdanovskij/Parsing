package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.DateNews
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.IgorBogdanovskij.data.repository.RepositoryImp
import com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.viewNewsFragment.NewsFragment
import com.example.parsingfilm.R
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

 class MainFragment(): Fragment(R.layout.fragment_main) {
    lateinit var mViewMain:ViewMain

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewModel = ViewModelProviders.of(this).get(ViewModelMainFragment::class.java)
        mViewMain = ViewMain(activity = requireActivity(), view = view, context = view.context, object:ViewMain.CallBack{



            override fun onClickAdapter(new: News) {
//                val bundle = Bundle()
//                bundle.putSerializable("new", new)
//                val fragment = NewsFragment()
//                fragment.arguments = bundle
//                activity?.supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.fragment, fragment)?.addToBackStack("")
//                    ?.commit()
                val a = MainFragmentDirections.actionMainFragmentToViewNewsFragment(new)
                findNavController().navigate(a)
            }

            override fun onClickTabs() {
            }

            override fun onClickNews() {
                Toast.makeText(context, "news", Toast.LENGTH_SHORT).show()
            }

            override fun onClickWishes() {
                Toast.makeText(context, "wishes", Toast.LENGTH_SHORT).show()

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