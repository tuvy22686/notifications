package com.github.tuvy22686.notifications.repository.main

import com.github.tuvy22686.notifications.model.main.NotificationType

interface MainRepository {
    fun getNotificationTypeList(): List<NotificationType>

    fun getNotificationType(index: Int): NotificationType

    fun editDescription(id: Long, description: String)
}