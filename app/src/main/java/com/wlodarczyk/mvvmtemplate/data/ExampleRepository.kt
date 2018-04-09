package com.wlodarczyk.mvvmtemplate.data

import android.content.Context
import com.wlodarczyk.mvvmtemplate.data.local.ExampleLocalDataSource
import com.wlodarczyk.mvvmtemplate.data.remote.ExampleRemoteDataSource
import com.wlodarczyk.mvvmtemplate.util.NetworkManager

class ExampleRepository(context: Context) {

    private val localDataSource = ExampleLocalDataSource()
    private val remoteDataSource = ExampleRemoteDataSource()
    private val networkManager = NetworkManager(context)

    fun getRepositories() =
            if (networkManager.isConnectedToInternet) {
                remoteDataSource.getRepositories()
            } else {
                localDataSource.getRepositories()
            }

}
