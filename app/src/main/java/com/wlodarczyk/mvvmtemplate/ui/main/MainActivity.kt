package com.wlodarczyk.mvvmtemplate.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.wlodarczyk.mvvmtemplate.R
import com.wlodarczyk.mvvmtemplate.databinding.ActivityMainBinding
import com.wlodarczyk.mvvmtemplate.model.ExampleModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(toolbar)

        val exampleModel = ExampleModel()
        binding.contentMain?.exampleModel = exampleModel
        binding.executePendingBindings()

        Handler().postDelayed({
            exampleModel.name = "Example"
        }, 2000)
    }
}
