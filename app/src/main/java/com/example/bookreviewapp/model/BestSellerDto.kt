package com.example.bookreviewapp.model

import com.google.gson.annotations.SerializedName

data class BestSellerDto<T> (
    @SerializedName("title") val title: String,
    @SerializedName("item") val books: List<T>
)