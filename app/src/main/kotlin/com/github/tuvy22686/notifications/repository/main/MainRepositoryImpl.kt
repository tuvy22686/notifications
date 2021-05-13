package com.github.tuvy22686.notifications.repository.main

import com.github.tuvy22686.notifications.R
import com.github.tuvy22686.notifications.model.main.NotificationType

class MainRepositoryImpl: MainRepository {

    private val notificationTypeList = listOf(
        NotificationType(0, "Toast", R.mipmap.icon_toast, "Toast通知が表示されます"),
        NotificationType(1, "Push", R.mipmap.icon_push, "Push通知が表示されます"),
        NotificationType(2, "Dialog", R.mipmap.icon_dialog, "アラートダイアログ通知が表示されます"),
        NotificationType(3, "Inline Message", R.mipmap.icon_inline, "インラインメッセージ通知を行います")
    ) as MutableList

    override fun getNotificationTypeList(): List<NotificationType> {
        return notificationTypeList
    }

    override fun getNotificationType(index: Int): NotificationType {
        return notificationTypeList[index]
    }

    override fun editDescription(id: Long, description: String) {
        notificationTypeList[notificationTypeList.indexOfFirst { it.id == id }] = NotificationType(id, "Inline Message", R.mipmap.icon_inline, description)
    }
}