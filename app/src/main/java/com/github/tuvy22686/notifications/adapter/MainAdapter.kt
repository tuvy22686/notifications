package com.github.tuvy22686.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.tuvy22686.notifications.databinding.ListMainBinding

class MainAdapter(private val dataset: List<String>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: ListMainBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ListMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val notificationTypeList = dataset[position]
        holder.binding.textView.text = notificationTypeList
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}