package com.example.bookreviewapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookreviewapp.api.RestApiRequest
import com.example.bookreviewapp.api.Retrofit
import com.example.bookreviewapp.model.Book
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private lateinit var mContext: Context
    private var _bookList = MutableLiveData<List<Book>>()
    val bookList : LiveData<List<Book>> get() = _bookList

    init {
        Retrofit.setRestApiService()
    }

    fun init(applicationContext: Context) {

        mContext = applicationContext
        getApi()
    }

    private fun getApi() = viewModelScope.launch {
        RestApiRequest.requestAsync({ Retrofit.service().getBestSeller(mContext.getString(R.string.interpark_apikey))}).collect { result ->
            _bookList.value = result.books
        }
    }

    private fun getBooksSearch(keyword: String) = viewModelScope.launch {
        RestApiRequest.requestAsync({ Retrofit.service().getBooksByName(mContext.getString(R.string.interpark_apikey), keyword)}).collect { result ->
            _bookList.value = result.books
        }
    }

    fun getSearch(keyword: String) {
        getBooksSearch(keyword)
    }

}