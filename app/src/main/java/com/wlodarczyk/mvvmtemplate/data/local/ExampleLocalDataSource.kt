package com.wlodarczyk.mvvmtemplate.data.local

import com.wlodarczyk.mvvmtemplate.model.ExampleModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class ExampleLocalDataSource {

    fun getRepositories(): Observable<ArrayList<ExampleModel>> {
        val arrayList = ArrayList<ExampleModel>()
        arrayList.add(ExampleModel("First", "Owner 1"))
        arrayList.add(ExampleModel("Second", "Owner 2"))
        arrayList.add(ExampleModel("Third", "Owner 3"))

        return Observable.just(arrayList).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<ExampleModel>): Completable =
            Single.just(arrayList).delay(1,TimeUnit.SECONDS).toCompletable()
}