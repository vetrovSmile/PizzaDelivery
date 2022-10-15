package com.example.pizzadelivery.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pizzadelivery.domain.modal.PizzaData

class PizzaMenuDiffCallBack : DiffUtil.ItemCallback<PizzaData>() {
    override fun areItemsTheSame(oldItem: PizzaData, newItem: PizzaData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PizzaData, newItem: PizzaData): Boolean {
        return oldItem == newItem
    }
}