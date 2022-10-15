package com.example.pizzadelivery.presentation.menu.tabitem.pizza

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzadelivery.domain.modal.PizzaModelItem
import com.example.pizzadelivery.domain.usecases.GetPizzaMenuDtoUseCase
import com.example.pizzadelivery.presentation.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PizzaFragmentViewModal @Inject constructor(
    private val getPizzaMenuDtoUseCase: GetPizzaMenuDtoUseCase
) : ViewModel() {

    private val _getPizzaMenu = MutableStateFlow(emptyList<PizzaModelItem>())
    val getPizzaMenu: StateFlow<List<PizzaModelItem>> = _getPizzaMenu.asStateFlow()

    private val _viewStatePizza = MutableLiveData<ViewState>()
    val viewStatePizza: LiveData<ViewState> = _viewStatePizza

    fun getPizzaList() {

        viewModelScope.launch(
            block = {
                val pizzaList = getPizzaMenuDtoUseCase.invoke()
                _getPizzaMenu.value = pizzaList
                _viewStatePizza.value = ViewState(true)
            },
            context = CoroutineExceptionHandler { _, throwable ->

            }
        )
    }
}

