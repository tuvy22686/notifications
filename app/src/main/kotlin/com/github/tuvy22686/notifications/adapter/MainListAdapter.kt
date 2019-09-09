package com.github.tuvy22686.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tuvy22686.notifications.databinding.ListMainBinding
import com.github.tuvy22686.notifications.viewmodel.main.MainListViewModelImpl
import com.github.tuvy22686.notifications.viewmodel.main.MainViewModel

class MainListAdapter(private val mainViewModel: MainViewModel) : RecyclerView.Adapter<MainListAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: ListMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ListMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.viewModel = mainViewModel.getListViewModel(position) as MainListViewModelImpl
    }

    override fun getItemCount(): Int {
        return mainViewModel.getNotificationTypeList().size
    }
}