package com.example.mvvm_di_kmm.android

import KoinInit
import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInit().initKoin()
    }
}
