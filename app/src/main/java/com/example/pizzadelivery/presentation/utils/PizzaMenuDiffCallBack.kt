package com.example.pizzadelivery.presentation.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pizzadelivery.domain.modal.PizzaModelItem

class PizzaMenuDiffCallBack : DiffUtil.ItemCallback<PizzaModelItem>() {
    override fun areItemsTheSame(oldItem: PizzaModelItem, newItem: PizzaModelItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PizzaModelItem, newItem: PizzaModelItem): Boolean {
        return oldItem == newItem
    }
}