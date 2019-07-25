package com.interpark.mvvmapplication

import android.app.Application
import com.interpark.mvvmapplication.di.roomModule
import com.interpark.mvvmapplication.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MvvmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(roomModule, viewModelModule))
    }
}