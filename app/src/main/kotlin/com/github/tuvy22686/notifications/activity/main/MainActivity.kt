package com.github.tuvy22686.notifications.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.tuvy22686.notifications.R
import com.github.tuvy22686.notifications.adapter.MainListAdapter
import com.github.tuvy22686.notifications.databinding.ActivityMainBinding
import com.github.tuvy22686.notifications.viewmodel.main.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

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
        recyclerView.adapter = MainListAdapter(mainViewModel)
    }
}
