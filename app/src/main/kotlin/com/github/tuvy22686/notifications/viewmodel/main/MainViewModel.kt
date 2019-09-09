package com.github.tuvy22686.notifications.viewmodel.main

import com.github.tuvy22686.notifications.model.main.NotificationType

interface MainViewModel {
    fun getNotificationTypeList(): List<NotificationType>
    fun getListViewModel(index: Int): MainListViewModel
}