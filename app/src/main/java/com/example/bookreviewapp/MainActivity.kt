package com.example.bookreviewapp

import androidx.activity.viewModels
import com.example.bookreviewapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutResourceId() = R.layout.activity_main
    private val viewModel : MainViewModel by viewModels()

    override fun initDataBinding() {
        mBinding.vm = viewModel
    }

    override fun initView() {
        TODO("Not yet implemented")
    }
}