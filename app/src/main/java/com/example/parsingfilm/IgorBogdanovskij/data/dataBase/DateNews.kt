package com.example.parsingfilm.IgorBogdanovskij.data.dataBase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
        val document = Jsoup.connect("https://gordonua.com/publications.html").get()
        val elements = document.select("div[class=media]")
        for (element in 0 until elements.size) {
            val description = elements.select("div[class=lenta_head]").eq(element).text()
            val linkImgSrc = "https://gordonua.com" + elements.select("div[class=span-4]")
                .select("div[class=lines_image ty67]").select("a").select("img").eq(element)
                .attr("data-src")
            val date = elements.select("div[class=for_data]").eq(element).text()
            listNews.add(News(description = description, image = linkImgSrc, date = date))
            _listNewsLiveData.postValue(listNews)
            Log.d("my", "getData:  ${listNews.size}")
        }
    }

}