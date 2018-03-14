package com.wlodarczyk.mvvmtemplate.data

import android.os.Handler
import com.wlodarczyk.mvvmtemplate.model.ExampleModel

class ExampleRepository {

    fun getExampleData(onDataReadyCallback: ExampleRepositoryCallback) = Handler().postDelayed({
        onDataReadyCallback.onDataReady("example data")
    }, 2000)

    fun getRepositories(onRepositoryReadyCallback: OnExamplesReadyCallback) {
        var arrayList = ArrayList<ExampleModel>()
        arrayList.add(ExampleModel("First", "Owner 1"))
        arrayList.add(ExampleModel("Second", "Owner 2"))
        arrayList.add(ExampleModel("Third", "Owner 3"))

        Handler().postDelayed({ onRepositoryReadyCallback.onDataReady(arrayList) },2000)
    }
}

interface ExampleRepositoryCallback {
    fun onDataReady(data: String)
}

interface OnExamplesReadyCallback {
    fun onDataReady(data : ArrayList<ExampleModel>)
}
