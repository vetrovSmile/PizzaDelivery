package com.example.pizzadelivery.presentation.menu.tabitem.pizza

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pizzadelivery.databinding.FragmentPizzaBinding
import com.example.pizzadelivery.presentation.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PizzaFragment : BaseFragment<FragmentPizzaBinding>(FragmentPizzaBinding::inflate) {

    private val viewModal by viewModels<PizzaFragmentViewModal>()
    private val viewPizzaAdapter = PizzaMenuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()
        initRvPizzaMenu()
        observePizzaMenu()
    }

    private fun observePizzaMenu() {
        viewModal.getPizzaList()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModal.getPizzaMenu.collect { pizzaModelItem ->
                    viewPizzaAdapter.submitList(pizzaModelItem)
                }
            }
        }

        viewModal.viewStatePizza.observe(viewLifecycleOwner) { viewState ->
            when {
                viewState.isDownload -> hideProgressBar()
            }
        }
    }

    private fun initRvPizzaMenu() {
        val viewPizzaRv = binding.rvPizzaMenu
        viewPizzaRv.adapter = viewPizzaAdapter
    }

    private fun showProgressBar() {
        binding.loadingBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.loadingBar.visibility = View.GONE
    }

    companion object {
        fun instance() = PizzaFragment()
    }
}