package com.example.evoting

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.evoting.di.KoinModule.dataModule
import com.example.evoting.di.KoinModule.uiModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    uiModule
                )
            )
        }
    }
}