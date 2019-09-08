package com.github.tuvy22686.notifications.repository.main

class MainRepositoryImpl: MainRepository {

    private val notificationTypeList = listOf(
        "Toast",
        "Push Notification",
        "Dialog",
        "Inline message",
        "hoge",
        "fuga",
        "hoga",
        "hoge",
        "fuga",
        "hoga",
        "hoge",
        "fuga",
        "hoga"
    )

    override fun getNotificationTypeList(): List<String> {
        return notificationTypeList
    }

    override fun getNotificationType(index: Int): String {
        return notificationTypeList[index]
    }
}