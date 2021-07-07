package com.example.parsingfilm.IgorBogdanovskij.data.dataBase.retrofit

import com.example.parsingfilm.IgorBogdanovskij.data.models.Wish
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiRetrofitWish {

    @GET("/api/qotd")
    fun getOneWish(): Call<Wish>
}


