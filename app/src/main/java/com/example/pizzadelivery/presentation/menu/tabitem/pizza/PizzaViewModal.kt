package com.example.pizzadelivery.presentation.menu.tabitem.pizza

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzadelivery.domain.modal.PizzaData
import com.example.pizzadelivery.domain.usecases.PizzaMenuFlowableUseCase
import com.example.pizzadelivery.domain.usecases.RequestPizzaMenuUseCase
import com.example.pizzadelivery.presentation.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class PizzaViewModal @Inject constructor(
    pizzaMenuFlowableUseCase: PizzaMenuFlowableUseCase,
    private val requestPizzaMenuUseCase: RequestPizzaMenuUseCase,
) : ViewModel() {

    val pizzaMenuFlowable = pizzaMenuFlowableUseCase().onEach(::changeLoadingState)

    private val _viewStatePizza = MutableStateFlow(ViewState())
    val viewStatePizza: StateFlow<ViewState> = _viewStatePizza.asStateFlow()

    fun getPizzaList() {
        viewModelScope.launch(
            block = { requestPizzaMenuUseCase() },
            context = CoroutineExceptionHandler(::handleCoroutineExceptions)
        )
    }

    private fun changeLoadingState(pizzaDataList: List<PizzaData>) {
        _viewStatePizza.value = _viewStatePizza.value.copy(
            isDownload = pizzaDataList.isNotEmpty(),
            isError = false
        )
    }

    private fun handleCoroutineExceptions(
        context: CoroutineContext,
        throwable: Throwable
    ) {
        if (throwable is UnknownHostException) return

        _viewStatePizza.value = _viewStatePizza.value.copy(
            isDownload = false,
            isError = true
        )
    }
}

