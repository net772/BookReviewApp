package com.example.bookreviewapp

import android.content.Context
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookreviewapp.api.RestApiRequest
import com.example.bookreviewapp.model.BestSellerDto
import com.example.bookreviewapp.model.Book
import com.example.bookreviewapp.model.SearchBooksDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        RestApiRequest.requestAsync({Retrofit.service().getBestSeller(mContext.getString(R.string.interpark_apikey))}).collect { result ->
            _bookList.value = result.books
        }
    }

//    private fun getBooksSearch(keyword: String) {
//        Retrofit.service().getBooksByName(mContext.getString(R.string.interpark_apikey), keyword)
//            .enqueue(object: Callback<SearchBooksDto> {
//                override fun onResponse(
//                    call: Call<SearchBooksDto>,
//                    response: Response<SearchBooksDto>,
//                ) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onFailure(call: Call<SearchBooksDto>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//    }

    fun getSearch(keyword: String) {
        //getBooksSearch(keyword)
    }

}