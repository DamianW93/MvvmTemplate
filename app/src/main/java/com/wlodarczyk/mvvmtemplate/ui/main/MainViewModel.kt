package com.wlodarczyk.mvvmtemplate.ui.main

import android.arch.lifecycle.ViewModel
import com.wlodarczyk.mvvmtemplate.data.ExampleRepository
import com.wlodarczyk.mvvmtemplate.data.OnExamplesReadyCallback
import com.wlodarczyk.mvvmtemplate.model.ExampleModel
import io.reactivex.subjects.BehaviorSubject

class MainViewModel : ViewModel() {

    private var exampleRepository: ExampleRepository = ExampleRepository()

    val isLoading: BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)
    val repositories: BehaviorSubject<ArrayList<ExampleModel>> =
            BehaviorSubject.createDefault(arrayListOf())

    fun loadExamples() {
        isLoading.onNext(true)
        exampleRepository.getRepositories(object : OnExamplesReadyCallback {
            override fun onDataReady(data: ArrayList<ExampleModel>) {
                isLoading.onNext(false)
                repositories.onNext(data)
            }
        })
    }
}