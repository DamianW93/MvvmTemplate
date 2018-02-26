package com.wlodarczyk.mvvmtemplate.ui.main

import android.databinding.ObservableField
import com.wlodarczyk.mvvmtemplate.data.ExampleRepository
import com.wlodarczyk.mvvmtemplate.data.ExampleRepositoryCallback

class MainViewModel {

    var exampleRepository: ExampleRepository = ExampleRepository()
    val isLoading = ObservableField(false)
    val text = ObservableField("")

    fun refreshData() {
        isLoading.set(true)
        exampleRepository.getExampleData(object : ExampleRepositoryCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }
}