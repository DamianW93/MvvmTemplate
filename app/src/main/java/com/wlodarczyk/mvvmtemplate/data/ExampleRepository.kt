package com.wlodarczyk.mvvmtemplate.data

import com.wlodarczyk.mvvmtemplate.data.local.ExampleLocalDataSource
import com.wlodarczyk.mvvmtemplate.data.remote.ExampleRemoteDataSource
import com.wlodarczyk.mvvmtemplate.model.ExampleModel
import com.wlodarczyk.mvvmtemplate.util.NetworkManager
import io.reactivex.Observable
import javax.inject.Inject

class ExampleRepository @Inject constructor(private val networkManager: NetworkManager) {

    private val localDataSource = ExampleLocalDataSource()
    private val remoteDataSource = ExampleRemoteDataSource()

    fun getRepositories(): Observable<ArrayList<ExampleModel>> =
            if (networkManager.isConnectedToInternet) {
                remoteDataSource.getRepositories().flatMap {
                    localDataSource.saveRepositories(it).toSingleDefault(it).toObservable()
                }
            } else {
                localDataSource.getRepositories()
            }

}
