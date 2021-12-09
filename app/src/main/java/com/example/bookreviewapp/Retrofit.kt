package com.example.bookreviewapp

import com.example.bookreviewapp.api.BookAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val TAG = "MainActivity"
    private const val BASE_URL = "https://book.interpark.com/"
    private lateinit var mRestApiService: BookAPI

    fun setRestApiService() {
        mRestApiService = Retrofit.Builder() // 레트로핏 구현체
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())  //gson변환
            .build()
            .create(BookAPI::class.java)
    }

    fun service(): BookAPI {
        return mRestApiService
    }

}