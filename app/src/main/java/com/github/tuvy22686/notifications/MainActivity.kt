package com.github.tuvy22686.notifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.tuvy22686.notifications.databinding.ActivityMainBinding
import com.github.tuvy22686.notifications.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
    }

    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = mainViewModel
    }
}
