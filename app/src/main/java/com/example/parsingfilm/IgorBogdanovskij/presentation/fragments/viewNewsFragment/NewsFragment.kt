package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.viewNewsFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.R
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import kotlin.coroutines.CoroutineContext

class NewsFragment:Fragment(R.layout.view_news_fragment) {


    private lateinit var mViewNewsFragment:ViewNewsFragment
   // private var mJob = Job
    private var mNew: News? = null
   // override val coroutineContext: CoroutineContext = Dispatchers.Main + mJob


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mNew = NewsFragmentArgs.fromBundle(requireArguments()).oneNews
      // mNew = arguments?.getSerializable("new") as News


        mViewNewsFragment = ViewNewsFragment(context = view.context, view = view)


        GlobalScope.launch(Dispatchers.IO) {
            getData()
        }

    }

   suspend fun getData() {
        var document = Jsoup.connect(mNew?.linkNews).get()

       Log.d("my", "getData: ${mNew?.linkNews}")
        var elements = document.select("div[class=text]")
            var description = elements.select("div[class=entry-content _ga1_on_]")
                .select("p")
                .text()
            var linkImgSrc = elements.select("figure[class=summary_img]")
                .select("img").attr("src")
            var title = elements.select("h2").text()

        withContext(Dispatchers.Main){
            mViewNewsFragment.mTitle.text = title
            title = null
            mViewNewsFragment.mDescription.text = description
            description = null
            document = null
            elements = null
            if(linkImgSrc.isNotEmpty()){
                Picasso.with(context)
                    .load(linkImgSrc)
                    .into(mViewNewsFragment.mImage)
                linkImgSrc = null
            }else{
                mViewNewsFragment.mImage.setImageDrawable(resources.getDrawable(R.drawable.ic_launcher_background, null))
            }

        }

    }





}