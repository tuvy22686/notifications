package com.github.tuvy22686.notifications.activity.main

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.tuvy22686.notifications.R
import com.github.tuvy22686.notifications.adapter.MainListAdapter
import com.github.tuvy22686.notifications.databinding.ActivityMainBinding
import com.github.tuvy22686.notifications.listener.MainListItemClickListener
import com.github.tuvy22686.notifications.push.LocalNotificationService
import com.github.tuvy22686.notifications.viewmodel.main.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainListItemClickListener {

    companion object {
        val ACTION_LOCAL_PUSH: String? = MainActivity::class.java.canonicalName
        const val REQUEST_CODE_LOCAL_PUSH: Int = 22686
        const val REQUEST_CODE_PERMISSION: Int = 11343
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
        setupPermission()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainListAdapter(mainViewModel, this)
    }

    private fun setupPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)) {
                Toast.makeText(this, "設定から通知を許可してください", Toast.LENGTH_LONG).show()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS), REQUEST_CODE_PERMISSION)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (!(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                Toast.makeText(this, "パーミッションが許可されていません", Toast.LENGTH_LONG).show()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onToastItemClick() {
        Toast.makeText(applicationContext, "トーストメッセージ", Toast.LENGTH_LONG).show()
    }

    override fun onPushItemClick() {
        println("MainActivity.onPushItemClick()")
        val intent = Intent(this, LocalNotificationService::class.java)
        intent.action = ACTION_LOCAL_PUSH
        val sender = PendingIntent.getBroadcast(this, REQUEST_CODE_LOCAL_PUSH, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, 0, sender)
    }

    override fun onInlineMessageItemClick() {
    }

    override fun onDialogItemClick() {
    }
}
