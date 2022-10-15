package com.example.pizzadelivery.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pizzadelivery.domain.BannersItem

class BannerSaleDiffCallBack : DiffUtil.ItemCallback<BannersItem>() {

    override fun areItemsTheSame(oldItem: BannersItem, newItem: BannersItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: BannersItem, newItem: BannersItem): Boolean {
        return oldItem == newItem
    }
}