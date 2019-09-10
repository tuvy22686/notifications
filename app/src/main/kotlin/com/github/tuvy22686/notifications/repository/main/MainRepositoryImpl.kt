package com.github.tuvy22686.notifications.repository.main

import com.github.tuvy22686.notifications.R
import com.github.tuvy22686.notifications.model.main.NotificationType

class MainRepositoryImpl: MainRepository {

    private val notificationTypeList = listOf(
        NotificationType(0, "Toast", R.mipmap.icon_toast),
        NotificationType(1, "Push", R.mipmap.icon_push),
        NotificationType(2, "Dialog", R.mipmap.icon_dialog),
        NotificationType(3, "Inline Message", R.mipmap.icon_inline)
    )

    override fun getNotificationTypeList(): List<NotificationType> {
        return notificationTypeList
    }

    override fun getNotificationType(index: Int): NotificationType {
        return notificationTypeList[index]
    }
}