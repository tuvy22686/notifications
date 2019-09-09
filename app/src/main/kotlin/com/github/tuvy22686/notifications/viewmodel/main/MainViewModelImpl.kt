package com.github.tuvy22686.notifications.viewmodel.main

import com.github.tuvy22686.notifications.repository.main.MainRepository

class MainViewModelImpl(private val mainRepository: MainRepository):
    MainViewModel {

    override fun getNotificationTypeList(): List<String> {
        return mainRepository.getNotificationTypeList()
    }
}