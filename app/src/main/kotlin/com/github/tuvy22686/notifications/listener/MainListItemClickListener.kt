package com.github.tuvy22686.notifications.listener

interface MainListItemClickListener {
    fun onToastItemClick()
    fun onPushItemClick()
    fun onDialogItemClick()
    fun onInlineMessageItemClick()
}