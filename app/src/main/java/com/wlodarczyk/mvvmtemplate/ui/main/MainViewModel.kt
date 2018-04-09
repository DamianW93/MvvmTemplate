package com.wlodarczyk.mvvmtemplate.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.wlodarczyk.mvvmtemplate.data.ExampleRepository
import com.wlodarczyk.mvvmtemplate.model.ExampleModel
import com.wlodarczyk.mvvmtemplate.util.extension.disposeWith
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val exampleRepository = ExampleRepository(getApplication())

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