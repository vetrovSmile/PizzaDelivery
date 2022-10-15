package com.example.pizzadelivery.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pizzadelivery.domain.modal.BannersModel

class BannerSaleDiffCallBack : DiffUtil.ItemCallback<BannersModel>() {

    override fun areItemsTheSame(oldItem: BannersModel, newItem: BannersModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: BannersModel, newItem: BannersModel): Boolean {
        return oldItem == newItem
    }
}