package com.sardorbek.roomwithrv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sardorbek.roomwithrv.databinding.ItemActivityBinding
import com.sardorbek.roomwithrv.model.Sport


class SportAdapter : ListAdapter<Sport, SportAdapter.SportViewHolder>(DiffCallBack()) {

    private class DiffCallBack : DiffUtil.ItemCallback<Sport>() {
        override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sport, newItem: Sport): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        return SportViewHolder(
            ItemActivityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SportViewHolder(private val binding: ItemActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sport: Sport) {
            binding.apply {
                textview1.text = sport.spinner
                type.text = sport.step
                textview2.text = sport.time
            }
        }
    }
}