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
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PizzaFragment : BaseFragment<FragmentPizzaBinding>(FragmentPizzaBinding::inflate) {

    private val viewModal by viewModels<PizzaFragmentViewModal>()
    private var viewPizzaAdapter: PizzaMenuAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRvPizzaMenu()
        observePizzaMenu()
    }

    private fun observePizzaMenu(){
        viewModal.getPizzaList()
        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.CREATED){
                viewModal.getPizzaMenu.collect{ pizzaModelItem ->
                    viewPizzaAdapter?.submitList(pizzaModelItem)
                }
            }
        }
    }
    private fun initRvPizzaMenu(){
        val viewPizzaRv = binding.rvPizzaMenu
         viewPizzaAdapter = PizzaMenuAdapter()
        viewPizzaRv.adapter = viewPizzaAdapter
    }

    companion object {
        fun instance() = PizzaFragment()
    }

}