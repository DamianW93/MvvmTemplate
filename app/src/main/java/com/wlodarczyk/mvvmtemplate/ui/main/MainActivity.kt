package com.wlodarczyk.mvvmtemplate.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wlodarczyk.mvvmtemplate.R
import com.wlodarczyk.mvvmtemplate.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.contentMain?.viewModel = mainViewModel
        binding.executePendingBindings()

        setSupportActionBar(toolbar)
    }
}
