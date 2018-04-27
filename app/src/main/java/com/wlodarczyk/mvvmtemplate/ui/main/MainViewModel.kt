package com.wlodarczyk.mvvmtemplate.ui.main

import android.arch.lifecycle.ViewModel
import com.wlodarczyk.mvvmtemplate.data.ExampleRepository
import com.wlodarczyk.mvvmtemplate.model.ExampleModel
import com.wlodarczyk.mvvmtemplate.util.extension.disposeWith
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(private var exampleRepository: ExampleRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val isLoading: BehaviorSubject<Boolean> = BehaviorSubject.createDefault(false)

    val repositories: BehaviorSubject<ArrayList<ExampleModel>> =
            BehaviorSubject.createDefault(arrayListOf())

    fun loadExamples() {
        exampleRepository.getRepositories()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({ isLoading.onNext(true) })
                .doFinally({ isLoading.onNext(false) })
                .subscribe({
                    repositories.onNext(it)
                }, { Timber.e(it) }).disposeWith(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}