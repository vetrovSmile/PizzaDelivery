package com.example.pizzadelivery.domain.usecases

import com.example.pizzadelivery.domain.PizzaDeliveryRepository
import com.example.pizzadelivery.domain.modal.PizzaData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PizzaMenuFlowableUseCase @Inject constructor(
    private val pizzaDeliveryRepository: PizzaDeliveryRepository
) {
    operator fun invoke(): Flow<List<PizzaData>> = pizzaDeliveryRepository.pizzaMenuFlowable()
}