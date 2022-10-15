package com.example.pizzadelivery.presentation.menu.tabitem.pizza

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pizzadelivery.databinding.MenuItemBinding
import com.example.pizzadelivery.domain.modal.PizzaData
import com.example.pizzadelivery.presentation.utils.PizzaMenuDiffCallBack

class PizzaMenuAdapter : ListAdapter<PizzaData, PizzaMenuViewHolder>(PizzaMenuDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaMenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = MenuItemBinding.inflate(
            inflater,
            parent,
            false
        )
        return PizzaMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PizzaMenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}