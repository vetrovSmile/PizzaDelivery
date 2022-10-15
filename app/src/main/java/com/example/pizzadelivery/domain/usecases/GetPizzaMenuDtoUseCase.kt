package com.example.pizzadelivery.domain.usecases

import com.example.pizzadelivery.domain.PizzaDeliveryRepository
import com.example.pizzadelivery.domain.modal.PizzaModelItem
import javax.inject.Inject

class GetPizzaMenuDtoUseCase @Inject constructor(
    private val pizzaDeliveryRepository: PizzaDeliveryRepository
) {
    suspend operator fun invoke(): List<PizzaModelItem> = pizzaDeliveryRepository.getPizzaMenu()
}