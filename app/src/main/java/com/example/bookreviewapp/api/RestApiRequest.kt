package com.example.bookreviewapp.api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object RestApiRequest {
    suspend fun <T> requestAsync(requestApi: suspend () -> T, onError: ((Throwable) -> Unit)? = null) = flow {
        Log.d("동현","requestAsync : ${requestApi}")
        emit(requestApi)
    }
        .flowOn(Dispatchers.IO)
        .catch { error ->
            onError?.invoke(error) ?: error.printStackTrace()
        }
}