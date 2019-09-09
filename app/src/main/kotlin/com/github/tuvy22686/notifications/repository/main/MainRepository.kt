package com.github.tuvy22686.notifications.repository.main

interface MainRepository {
    fun getNotificationTypeList(): List<String>

    fun getNotificationType(index: Int): String
}