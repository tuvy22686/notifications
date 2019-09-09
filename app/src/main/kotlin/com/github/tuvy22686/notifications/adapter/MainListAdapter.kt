package com.github.tuvy22686.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tuvy22686.notifications.databinding.ListMainBinding
import com.github.tuvy22686.notifications.listener.MainListItemClickListener
import com.github.tuvy22686.notifications.viewmodel.main.MainListViewModelImpl
import com.github.tuvy22686.notifications.viewmodel.main.MainViewModel

class MainListAdapter(private val mainViewModel: MainViewModel, private val listener: MainListItemClickListener) : RecyclerView.Adapter<MainListAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: ListMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ListMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val mainListViewModel = mainViewModel.getListViewModel(position)
        holder.binding.viewModel = mainListViewModel as MainListViewModelImpl
        holder.binding.root.setOnClickListener {
            when (position) {
                0 -> {
                    listener.onToastItemClick()
                }
                1 -> {
                    listener.onPushItemClick()
                }
                2 -> {
                    listener.onDialogItemClick()
                }
                3 -> {
                    listener.onInlineMessageItemClick()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mainViewModel.getNotificationTypeList().size
    }
}