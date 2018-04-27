package com.wlodarczyk.mvvmtemplate.dependency.app

import com.wlodarczyk.mvvmtemplate.App
import com.wlodarczyk.mvvmtemplate.dependency.helpers.ViewModelBuilder
import com.wlodarczyk.mvvmtemplate.dependency.main.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidSupportInjectionModule::class,
            AppModule::class,
            ViewModelBuilder::class,
            MainActivityModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}