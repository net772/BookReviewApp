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
    protected val mDispatcherDefault = Dispatchers.Default
    private var _bookList = MutableLiveData<List<Book>>()
    val bookList : LiveData<List<Book>> get() = _bookList

    //var bookList = ObservableField<List<Book>>()

    fun init(applicationContext: Context) {
        mContext = applicationContext
        Log.d("동현","1111111111111")
        getApi()
        Log.d("동현","22222222222222")
    }

    private fun getApi() = viewModelScope.launch {
        Retrofit.setRestApiService()
        RestApiRequest.requestAsync({Retrofit.service().getBestSeller(mContext.getString(R.string.interpark_apikey))}).collect { result ->
            Log.d("동현","result:${result}")
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