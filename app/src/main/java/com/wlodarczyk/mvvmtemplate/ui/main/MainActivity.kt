package com.wlodarczyk.mvvmtemplate.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.wlodarczyk.mvvmtemplate.R
import com.wlodarczyk.mvvmtemplate.ui.main.recycler.ExampleRecyclerViewAdapter
import com.wlodarczyk.mvvmtemplate.ui.main.recycler.OnItemClickListener

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initializeRecycler()
        subscribeToData()

        refreshButton.setOnClickListener { viewModel.loadExamples() }
    }

    private fun initializeRecycler() {
        repositoryRecycler.layoutManager = LinearLayoutManager(this)
        repositoryRecycler.adapter = ExampleRecyclerViewAdapter(viewModel.repositories.value, this)
    }

    private fun subscribeToData() {
        viewModel.isLoading.subscribe({ loading ->
            progressBar.visibility = if (loading) View.VISIBLE else View.GONE
            repositoryRecycler.visibility = if (loading) View.GONE else View.VISIBLE
            refreshButton.isEnabled = !loading
        }, { Timber.e(it) })

        viewModel.repositories.subscribe({ data ->
            repositoryRecycler.adapter = ExampleRecyclerViewAdapter(data, this)
        }, { Timber.e(it) })
    }

    override fun onItemClick(position: Int) {

    }
}
