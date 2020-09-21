package com.example.stateexample

import android.app.Application
import com.example.stateexample.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BeerApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BeerApplication)
            androidLogger()

            modules(appModule)
        }
    }
}