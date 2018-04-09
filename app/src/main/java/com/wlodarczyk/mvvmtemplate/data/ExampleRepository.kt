package com.wlodarczyk.mvvmtemplate.data

import android.content.Context
import com.wlodarczyk.mvvmtemplate.data.local.ExampleLocalDataSource
import com.wlodarczyk.mvvmtemplate.data.remote.ExampleRemoteDataSource
import com.wlodarczyk.mvvmtemplate.model.ExampleModel
import com.wlodarczyk.mvvmtemplate.util.NetworkManager
import io.reactivex.Observable

class ExampleRepository(context: Context) {

    private val localDataSource = ExampleLocalDataSource()
    private val remoteDataSource = ExampleRemoteDataSource()
    private val networkManager = NetworkManager(context)

    fun getRepositories(): Observable<ArrayList<ExampleModel>> =
            if (networkManager.isConnectedToInternet) {
                remoteDataSource.getRepositories().flatMap {
                    localDataSource.saveRepositories(it).toSingleDefault(it).toObservable()
                }
            } else {
                localDataSource.getRepositories()
            }

}
