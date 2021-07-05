package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.DateNews
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.IgorBogdanovskij.data.repository.RepositoryImp

class ViewModelMainFragment: ViewModel() {

    var dataBase: DateNews = DateNews()
    var repo: RepositoryImp = RepositoryImp(dataBase)


    fun getNews():LiveData<MutableList<News>>{
        return repo.getNews()
    }

}