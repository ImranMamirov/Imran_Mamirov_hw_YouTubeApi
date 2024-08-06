package com.example.imran_mamirov_hw_youtubeapi

import android.app.Application
import com.example.imran_mamirov_hw_youtubeapi.di.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}