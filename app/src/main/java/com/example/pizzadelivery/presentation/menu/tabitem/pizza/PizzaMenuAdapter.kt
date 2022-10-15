package com.example.pizzadelivery.presentation.menu.tabitem.pizza

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.pizzadelivery.R
import com.example.pizzadelivery.databinding.MenuItemBinding
import com.example.pizzadelivery.domain.modal.PizzaModelItem
import com.example.pizzadelivery.presentation.utils.PizzaMenuDiffCallBack

class PizzaMenuAdapter : ListAdapter<PizzaModelItem, PizzaMenuViewHolder>(PizzaMenuDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaMenuViewHolder {
        val binding =
           MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PizzaMenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PizzaMenuViewHolder, position: Int) {
        val getPizzaMenu = getItem(position)
        with(holder.binding){
            headerTitle.text = getPizzaMenu.name
            descriptionMenu.text = getPizzaMenu.dsc
            Glide.with(holder.itemView.context).load(getPizzaMenu.img).into(imageProduct)
            buttonCostMenu.text = String.format(holder.itemView.context.getString(R.string.cost),
                getPizzaMenu.price.toString() )
        }
    }
}