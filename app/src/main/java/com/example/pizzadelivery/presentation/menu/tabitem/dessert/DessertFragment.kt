package com.example.pizzadelivery.presentation.menu.tabitem.dessert

import com.example.pizzadelivery.databinding.FragmentDessertBinding
import com.example.pizzadelivery.presentation.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DessertFragment : BaseFragment<FragmentDessertBinding>(
    inflate = FragmentDessertBinding::inflate
) {
    companion object {
        fun instance() = DessertFragment()
    }
}