package com.example.bookreviewapp.adapter

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bookreviewapp.model.Book


object BindingAdapter {

    @BindingAdapter("items")
    @JvmStatic
    fun <T> setList(recyclerView: RecyclerView, items: List<T>?) {
          Log.d("동현","items : $items")

        var adapter = recyclerView.adapter
        if(adapter != null) {
            (adapter as BookAdapter).submitList(items?.filterIsInstance(Book::class.java))
        }


    }

    @BindingAdapter("onClickListener")
    @JvmStatic
    fun setOnClickListener(view: View, listener: View.OnClickListener?) {
        view.setOnClickListener(listener)
    }
}