package com.wlodarczyk.mvvmtemplate.util

import android.content.Context
import android.net.ConnectivityManager

class NetworkManager(private var applicationContext: Context) {

    val isConnectedToInternet: Boolean
        get() {
            val conManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return conManager.activeNetworkInfo?.isConnected ?: false
        }
}