package com.example.bookreviewapp.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val TAG = "MainActivity"
    private const val BASE_URL = "https://book.interpark.com/"
    private lateinit var mRestApiService: BookAPI

    fun setRestApiService() {
        mRestApiService = Retrofit.Builder() // 레트로핏 구현체
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())  //gson변환
            .build()
            .create(BookAPI::class.java)
    }

    fun service(): BookAPI {
        return mRestApiService
    }

}