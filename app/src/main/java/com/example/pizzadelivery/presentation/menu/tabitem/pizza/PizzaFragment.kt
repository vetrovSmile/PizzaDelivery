package com.example.pizzadelivery.presentation.menu.tabitem.pizza

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pizzadelivery.R
import com.example.pizzadelivery.databinding.FragmentPizzaBinding
import com.example.pizzadelivery.presentation.utils.BaseFragment
import com.example.pizzadelivery.presentation.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PizzaFragment : BaseFragment<FragmentPizzaBinding>(FragmentPizzaBinding::inflate) {

    private val viewModal by viewModels<PizzaViewModal>()
    private val viewPizzaAdapter = PizzaMenuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showProgressBar()
        initPizzaMenu()
        observePizzaMenu()
        observeLoadingState()
    }

    private fun observePizzaMenu() {
        viewModal.getPizzaList()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModal.pizzaMenuFlowable.collect { pizzaModelItem ->
                    viewPizzaAdapter.submitList(pizzaModelItem)
                }
            }
        }
    }

    private fun observeLoadingState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModal.viewStatePizza.collect { viewState ->
                    with(viewState) {
                        when {
                            isDownload -> hideProgressBar()
                            isError -> {
                                hideProgressBar()
                                Toast.makeText(
                                    requireContext(),getString(R.string.error) ,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun initPizzaMenu() {
        val pizzasRecyclerView = binding.rvPizzaMenu
        pizzasRecyclerView.adapter = viewPizzaAdapter
    }

    private fun showProgressBar() {
        binding.loadingBar.visible = true
    }

    private fun hideProgressBar() {
        binding.loadingBar.visible = false
    }

    companion object {
        fun instance() = PizzaFragment()
    }
}