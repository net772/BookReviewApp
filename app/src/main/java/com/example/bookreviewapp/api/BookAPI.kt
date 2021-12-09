package com.example.bookreviewapp.api

import com.example.bookreviewapp.model.BestSellerDto
import com.example.bookreviewapp.model.SearchBooksDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BookAPI {
    @GET("/api/bestSeller.api?categoryId=100&output=json")
    suspend fun getBestSeller(@Query("key") apiKey: String) : BestSellerDto

    @GET("/api/search.api?output=json")
    suspend fun getBooksByName(
        @Query("key") apiKey: String,
        @Query("query") keyword: String
    ): SearchBooksDto
}