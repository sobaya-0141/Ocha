package com.example.ocha

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val module = module {
            viewModel { MainViewModel() }
        }
        startKoin {
            androidContext(this@App)
            modules(module)
        }
    }
}
