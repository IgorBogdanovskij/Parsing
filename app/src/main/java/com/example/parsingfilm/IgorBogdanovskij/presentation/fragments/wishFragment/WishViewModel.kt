package com.example.parsingfilm.IgorBogdanovskij.presentation.fragments.wishFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.parsingfilm.IgorBogdanovskij.data.dataBase.Date
import com.example.parsingfilm.IgorBogdanovskij.data.models.Wish
import com.example.parsingfilm.IgorBogdanovskij.data.repository.RepositoryImp

class WishViewModel:ViewModel() {
    var dataBase: Date = Date()
    var repo: RepositoryImp = RepositoryImp(dataBase)


    fun getOneNew():LiveData<Wish>{
        return repo.getOneWish()
    }

}