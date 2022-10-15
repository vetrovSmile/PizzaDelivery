package com.example.pizzadelivery.presentation.menu.tabitem.combo

import com.example.pizzadelivery.databinding.FragmentComboBinding
import com.example.pizzadelivery.presentation.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComboFragment : BaseFragment<FragmentComboBinding>(
    inflate = FragmentComboBinding::inflate
) {
    companion object {
        fun instance() = ComboFragment()
    }
}