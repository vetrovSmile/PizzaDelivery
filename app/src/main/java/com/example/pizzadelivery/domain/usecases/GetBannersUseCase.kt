package com.example.pizzadelivery.domain.usecases

import com.example.pizzadelivery.domain.PizzaDeliveryRepository
import javax.inject.Inject

class GetBannersUseCase @Inject constructor(
    private val pizzaDeliveryRepository: PizzaDeliveryRepository
) {

    suspend operator fun invoke() = pizzaDeliveryRepository.getSaleBanner()
}