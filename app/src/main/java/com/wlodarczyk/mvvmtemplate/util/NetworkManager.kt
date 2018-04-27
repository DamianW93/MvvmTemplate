package com.wlodarczyk.mvvmtemplate.util

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkManager @Inject constructor(private var applicationContext: Context) {

    val isConnectedToInternet: Boolean
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return conManager.activeNetworkInfo?.isConnected ?: false
        }
}