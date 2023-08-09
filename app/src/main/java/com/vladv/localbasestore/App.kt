package com.vladv.localbasestore

import android.app.Application
import com.google.firebase.FirebaseApp
import com.vladv.testlocalbase.di.appModule
import com.vladv.testlocalbase.di.dataModule
import com.vladv.testlocalbase.di.domainModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}