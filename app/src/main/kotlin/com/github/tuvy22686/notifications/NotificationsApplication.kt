package com.github.tuvy22686.notifications

import android.app.Application
import com.github.tuvy22686.notifications.repository.main.MainRepository
import com.github.tuvy22686.notifications.repository.main.MainRepositoryImpl
import com.github.tuvy22686.notifications.viewmodel.main.MainViewModel
import com.github.tuvy22686.notifications.viewmodel.main.MainViewModelImpl
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class NotificationsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
            this.repositoryModule,
            this.viewModelModule
        ))
    }

    private val repositoryModule: Module = module {
        factory { MainRepositoryImpl() as MainRepository }
    }

    private val viewModelModule: Module = module {
        factory { MainViewModelImpl(get()) as MainViewModel }
    }
}