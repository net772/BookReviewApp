package com.example.bookreviewapp.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class CustomRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    abstract fun <T> replaceData(list: List<T>?)
    open fun onScrollTop() {}
    open fun onScrollBottom() {}
}