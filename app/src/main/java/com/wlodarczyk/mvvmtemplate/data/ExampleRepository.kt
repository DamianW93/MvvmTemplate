package com.wlodarczyk.mvvmtemplate.data

import android.os.Handler

class ExampleRepository {

    fun getExampleData(onDataReadyCallback: ExampleRepositoryCallback) = Handler().postDelayed({
        onDataReadyCallback.onDataReady("example data")
    }, 2000)
}

interface ExampleRepositoryCallback {
    fun onDataReady(data: String)
}