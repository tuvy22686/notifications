package com.github.tuvy22686.notifications.viewmodel.main

import com.github.tuvy22686.notifications.model.main.NotificationType

class MainListViewModelImpl(private val notificationType: NotificationType) : MainListViewModel {

    override fun getNotificationMessage(): String {
        return notificationType.title
    }
}