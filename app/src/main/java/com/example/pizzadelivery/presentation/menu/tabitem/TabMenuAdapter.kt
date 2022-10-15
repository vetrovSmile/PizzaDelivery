package com.example.pizzadelivery.presentation.menu.tabitem

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pizzadelivery.presentation.menu.tabitem.combo.ComboFragment
import com.example.pizzadelivery.presentation.menu.tabitem.dessert.DessertFragment
import com.example.pizzadelivery.presentation.menu.tabitem.pizza.PizzaFragment

class TabMenuAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PizzaFragment.instance()
            1 -> ComboFragment.instance()
            2 -> DessertFragment.instance()
            else -> DessertFragment.instance()
        }
    }
}