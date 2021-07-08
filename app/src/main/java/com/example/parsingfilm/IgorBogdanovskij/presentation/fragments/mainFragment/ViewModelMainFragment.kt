package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.mainFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.Date
import com.example.parsingfilm.IgorBogdanovskij.data.models.News
import com.example.parsingfilm.IgorBogdanovskij.data.repository.RepositoryImp

class ViewModelMainFragment: ViewModel() {

    var dataBase: Date = Date()
    var repo: RepositoryImp = RepositoryImp(dataBase)


    fun getNews():LiveData<MutableList<News>>{
        return repo.getNews()
    }

}