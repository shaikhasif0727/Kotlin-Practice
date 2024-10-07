package com.gaming.kotlinpracticeproject

import android.app.Application
import com.gaming.kotlinpracticeproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApp)
            androidLogger()

            modules(appModule)
        }
    }
}