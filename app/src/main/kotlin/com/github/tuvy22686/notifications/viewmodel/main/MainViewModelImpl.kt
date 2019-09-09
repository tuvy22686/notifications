package com.github.tuvy22686.notifications.viewmodel.main

import com.github.tuvy22686.notifications.model.main.NotificationType
import com.github.tuvy22686.notifications.repository.main.MainRepository

class MainViewModelImpl(private val mainRepository: MainRepository):
    MainViewModel {

    override fun getNotificationTypeList(): List<NotificationType> {
        return mainRepository.getNotificationTypeList()
    }

    override fun getListViewModel(index: Int): MainListViewModel {
        return MainListViewModelImpl(mainRepository.getNotificationType(index))
    }
}