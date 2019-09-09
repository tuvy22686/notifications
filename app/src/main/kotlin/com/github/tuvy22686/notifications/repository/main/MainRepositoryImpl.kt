package com.github.tuvy22686.notifications.repository.main

import com.github.tuvy22686.notifications.model.main.NotificationType

class MainRepositoryImpl: MainRepository {

    private val notificationTypeList = listOf(
        NotificationType(0, "Toast"),
        NotificationType(1, "Push"),
        NotificationType(2, "Dialog"),
        NotificationType(3, "Inline Message")
    )

    override fun getNotificationTypeList(): List<NotificationType> {
        return notificationTypeList
    }

    override fun getNotificationType(index: Int): NotificationType {
        return notificationTypeList[index]
    }
}