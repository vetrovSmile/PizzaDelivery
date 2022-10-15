package com.example.pizzadelivery.presentation.menu.tabitem.pizza

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pizzadelivery.R
import com.example.pizzadelivery.databinding.MenuItemBinding
import com.example.pizzadelivery.domain.modal.PizzaData

class PizzaMenuViewHolder(
    private val binding: MenuItemBinding
) : RecyclerView.ViewHolder(binding.root), ViewHolder<PizzaData> {
    override fun bind(model: PizzaData) {
        with(binding) {
            headerTitle.text = model.name
            descriptionMenu.text = model.description
            Glide.with(itemView.context)
                .load(model.image)
                .circleCrop()
                .placeholder(R.drawable.ic_menu)
                .error(R.drawable.ic_broken_image_24)
                .into(imageProduct)

            buttonCostMenu.text = String.format(
                itemView.context.getString(R.string.cost),
                model.price.toString()
            )
        }
    }
}