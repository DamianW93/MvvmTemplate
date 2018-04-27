package com.wlodarczyk.mvvmtemplate.dependency.app

import android.content.Context
import com.wlodarczyk.mvvmtemplate.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideAppContext(application: App): Context =
            application.applicationContext
}