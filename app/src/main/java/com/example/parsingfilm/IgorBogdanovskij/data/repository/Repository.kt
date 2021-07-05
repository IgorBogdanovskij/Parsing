package com.example.parsingfilm.IgorBogdanovskij.data.repository

import androidx.lifecycle.LiveData
import com.example.parsingfilm.IgorBogdanovskij.data.models.News

interface Repository {
    fun getNews():LiveData<MutableList<News>>
}