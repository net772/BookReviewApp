package com.example.bookreviewapp

import android.view.KeyEvent
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookreviewapp.adapter.BookAdapter
import com.example.bookreviewapp.api.BookAPI
import com.example.bookreviewapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutResourceId() = R.layout.activity_main
    private val viewModel : MainViewModel by viewModels()
    private lateinit var adapter: BookAdapter

    override fun initDataBinding() {
        mBinding.lifecycleOwner = this
        mBinding.vm = viewModel
        viewModel.init(applicationContext)
    }

    override fun initView() {
        setAdapter()
        setKey()
    }

    private fun setKey() {
        mBinding.searchEditText.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                search(mBinding.searchEditText.text.toString())
                return@setOnKeyListener true        // 이벤트를 처리를 했음을 true
            }
            return@setOnKeyListener false       // 이벤트를 처리를 x false
        }
    }

    private fun search(keyword: String) {
        viewModel.getSearch(keyword)
    }

    private fun setAdapter() {
        adapter = BookAdapter()
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mBinding.recyclerView.adapter = adapter
    }
}


