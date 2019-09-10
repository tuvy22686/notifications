package com.github.tuvy22686.notifications.activity.main

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.tuvy22686.notifications.R
import com.github.tuvy22686.notifications.adapter.MainListAdapter
import com.github.tuvy22686.notifications.databinding.ActivityMainBinding
import com.github.tuvy22686.notifications.listener.MainListItemClickListener
import com.github.tuvy22686.notifications.viewmodel.main.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainListItemClickListener {

    companion object {
        const val CHANNEL_ID: String = "MAIN_ACTIVITY.CHANNEL_ID"

        fun createIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private val binding by lazy {
        DataBindingUtil.setContentView(this,
            R.layout.activity_main
        ) as ActivityMainBinding
    }

    private val mainViewModel by inject<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = mainViewModel
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainListAdapter(mainViewModel, this)
    }

    override fun onToastItemClick() {
        Toast.makeText(applicationContext, "トーストメッセージ", Toast.LENGTH_LONG).show()
    }

    override fun onPushItemClick() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val title = "Title"
        val description = "Description"

        if (Build.VERSION.SDK_INT >= 26 && notificationManager.getNotificationChannel(CHANNEL_ID) == null) {
            val channel = NotificationChannel(CHANNEL_ID, title, NotificationManager.IMPORTANCE_HIGH)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .apply {
                setSmallIcon(R.drawable.ic_launcher_foreground)
                setContentTitle(title)
                setContentText(description)
                setAutoCancel(true)
                setWhen(System.currentTimeMillis())
                setContentIntent(PendingIntent.getActivity(this@MainActivity, 0, createIntent(this@MainActivity), 0))
            }
            .build()
        notificationManager.notify(AlarmManager.RTC_WAKEUP, notification)
    }

    override fun onInlineMessageItemClick() {
    }

    override fun onDialogItemClick() {
    }
}
