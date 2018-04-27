package com.wlodarczyk.mvvmtemplate.dependency.main

import android.arch.lifecycle.ViewModel
import com.wlodarczyk.mvvmtemplate.dependency.helpers.ViewModelKey
import com.wlodarczyk.mvvmtemplate.ui.main.MainActivity
import com.wlodarczyk.mvvmtemplate.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}