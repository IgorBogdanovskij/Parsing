package com.example.parsingfilm.IgorBogdanovskij.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.DateNews
import com.example.parsingfilm.IgorBogdanovskij.data.models.News

class RepositoryImp(private val DateNews: DateNews):Repository {

    override fun getNews(): LiveData<MutableList<News>> {
        return this.DateNews.listNewsLiveData
    }



}