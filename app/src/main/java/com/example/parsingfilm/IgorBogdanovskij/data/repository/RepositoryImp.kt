package com.example.parsingfilm.IgorBogdanovskij.data.repository

import androidx.lifecycle.LiveData
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.Date
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.IgorBogdanovskij.data.models.Wish
import retrofit2.Retrofit

class RepositoryImp(private val date: Date):Repository {

    override fun getNews(): LiveData<MutableList<News>> {
        return this.date.listNewsLiveData
    }

    override fun getOneWish(): LiveData<Wish> {
        return date.oneNews
    }


}