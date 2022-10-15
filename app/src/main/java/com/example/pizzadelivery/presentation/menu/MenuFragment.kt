package com.example.pizzadelivery.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pizzadelivery.databinding.FragmentMenuBinding
import com.example.pizzadelivery.databinding.TabTextBinding
import com.example.pizzadelivery.presentation.menu.tabitem.TabMenuAdapter
import com.example.pizzadelivery.presentation.utils.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    private val viewModal by viewModels<MenuFragmentViewModal>()
    private var bannerMenuAdapter: MenuAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabMenu()
        bannerInitRv()
        observeBannerSale()
    }

    private fun observeBannerSale(){
        viewModal.getBannerItem()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModal.getBanners.collect{
                    bannerMenuAdapter?.submitList(it)

                }
            }
        }

    }
    private fun bannerInitRv(){
        val bannerRv = binding.rvSaleBanner
        bannerMenuAdapter = MenuAdapter()
        bannerRv.adapter = bannerMenuAdapter

    }

    private fun initTabMenu() {

        val tapItem = listOf("Пицца", "Комбо", "Десерты", "Напитки")
        val tabAdapter = TabMenuAdapter(childFragmentManager, lifecycle)

        binding.viewPagerMenu.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayoutMenu, binding.viewPagerMenu) { tab, position ->
            tab.text = tapItem[position]
        }.attach()

        repeat(4) {
            val textTab = TabTextBinding.inflate(LayoutInflater.from(requireContext()))
            binding.tabLayoutMenu.getTabAt(it)?.customView = textTab.root
        }
    }
}