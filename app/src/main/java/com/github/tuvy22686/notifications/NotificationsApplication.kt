package com.github.tuvy22686.notifications

import android.app.Application
import com.github.tuvy22686.notifications.viewmodel.MainViewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class NotificationsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            this.module
        ))
    }

    private val module: Module = module {
        factory { MainViewModel() }
    }
}