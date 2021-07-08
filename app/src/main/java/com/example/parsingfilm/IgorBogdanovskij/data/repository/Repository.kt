package com.example.parsingfilm.IgorBogdanovskij.data.repository

import androidx.lifecycle.LiveData
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.IgorBogdanovskij.data.models.Wish
import retrofit2.Retrofit

interface Repository {
    fun getNews():LiveData<MutableList<News>>
    fun getOneWish():LiveData<Wish>

}