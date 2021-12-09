package com.example.bookreviewapp

import androidx.lifecycle.ViewModel
import com.example.bookreviewapp.model.BestSellerDto

open class BaseViewModel : ViewModel() {
    protected suspend fun <B: BestSellerDto<T>, T> requestApi(type: String, restApi: suspend () -> B, onCollect: (T) -> Unit, onError:(Throwable) -> Unit) {

    }
}