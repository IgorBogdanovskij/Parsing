package com.example.parsingfilm.IgorBogdanovskij.data.dataBase

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.retrofit.ApiRetrofitWish
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.retrofit.RetrofitClient
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.IgorBogdanovskij.data.models.Wish
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import retrofit2.await

class Date() {


    private val _listNewsLiveData = MutableLiveData<MutableList<News>>()
    val listNewsLiveData:LiveData<MutableList<News>>
    get() = _listNewsLiveData
    var listNews = mutableListOf<News>()


    private val _oneNews = MutableLiveData<Wish>()
    val oneNews:LiveData<Wish>
    get() = _oneNews


    init {
        GlobalScope.launch() {
            withContext(Dispatchers.IO){
                getNews()
                getOneWish()
            }
        }

    }

    private suspend fun getOneWish() {
        val response = RetrofitClient.getClient().create(ApiRetrofitWish::class.java)
        _oneNews.postValue(response.getOneWish().await())
    }

    private fun getNews() {
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
        }
    }

}