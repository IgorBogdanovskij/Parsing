package com.example.parsingfilm.IgorBogdanovskij.data.dataBase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import kotlinx.coroutines.*
import org.jsoup.Jsoup

class DateNews() {


    private val _listNewsLiveData = MutableLiveData<MutableList<News>>()
    val listNewsLiveData:LiveData<MutableList<News>>
    get() = _listNewsLiveData
    var listNews = mutableListOf<News>()

    init {

        GlobalScope.launch() {
            withContext(Dispatchers.IO){
                getData()
            }
        }
    }

    private fun getData() {
        val document = Jsoup.connect("https://censor.net/ru/news/all").get()
        val elements = document.select("article[class=item type1]")
        for (element in 0 until elements.size) {
            val description = elements.select("div[class=anounce]").eq(element)
                .select("a")
                .text()
            val linkImgSrc = elements.select("a[class=news_img]")
                .select("img").eq(element).attr("src")
            val date = elements.select("article[class=item type1]").eq(element)
                .select("time")
                .text()
            val title = elements.select("article[class=item type1]").eq(element)
                .select("a")
                .attr("title")
            val linkNews = elements.select("div[class=anounce]").select("a").eq(element).attr("href")
            listNews.add(News(title = title, description = description, image = linkImgSrc, date = date, linkNews = linkNews))
            _listNewsLiveData.postValue(listNews)
            Log.d("my", "getData:  ${listNews.size}")
        }
    }

}