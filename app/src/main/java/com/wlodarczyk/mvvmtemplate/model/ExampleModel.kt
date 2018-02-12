package com.wlodarczyk.mvvmtemplate.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.wlodarczyk.mvvmtemplate.BR

class ExampleModel: BaseObservable() {

    @get:Bindable
    var name: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.name)
    }

    var surname: String? = null
}

