package com.github.tuvy22686.notifications.push

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.github.tuvy22686.notifications.R
import com.github.tuvy22686.notifications.activity.main.MainActivity

class LocalNotificationService : BroadcastReceiver() {

    companion object {
        const val INTENT_KEY_LOCAL_PUSH = "INTENT_KEY_LOCAL_PUSH"
        const val CHANNEL_ID = "COM_GITHUB_TUVY22686_NOTIFICATIONS"
    }

    override fun onReceive(context: Context, intent: Intent) {
        println("LocalNotificationService.onReceived()")
        if (intent.action == MainActivity.ACTION_LOCAL_PUSH) {
            println("action")
            val largeIcon: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_launcher_foreground)
            val notificationIntent = Intent(context, MainActivity::class.java)
            notificationIntent.putExtra(INTENT_KEY_LOCAL_PUSH, true)
            val pendingIntent = PendingIntent.getActivity(context, MainActivity.REQUEST_CODE_LOCAL_PUSH, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT)
            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            builder.apply {
                setWhen(System.currentTimeMillis())
                setSmallIcon(R.drawable.ic_launcher_foreground)
                setLargeIcon(largeIcon)
                setTicker("ticker")
                setContentTitle("title")
                setContentText("text")
                setContentIntent(pendingIntent)
                setAutoCancel(true)
            }
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, builder.build())
        }
    }
}