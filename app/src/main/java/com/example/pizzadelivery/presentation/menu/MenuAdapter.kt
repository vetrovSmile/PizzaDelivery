package com.example.pizzadelivery.presentation.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.pizzadelivery.databinding.SaleMenuItemBinding
import com.example.pizzadelivery.domain.BannersItem
import com.example.pizzadelivery.presentation.utils.BannerSaleDiffCallBack

class MenuAdapter : ListAdapter<BannersItem, MenuViewHolder>(BannerSaleDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding =
            SaleMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val getBanner = getItem(position)
        Glide.with(holder.itemView.context).load(getBanner.icon).into(holder.binding.saleMenuImage)
    }
}