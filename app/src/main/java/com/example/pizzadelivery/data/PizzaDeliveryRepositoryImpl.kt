package com.example.pizzadelivery.data

import com.example.pizzadelivery.R
import com.example.pizzadelivery.domain.BannersItem
import com.example.pizzadelivery.domain.PizzaDeliveryRepository
import com.example.pizzadelivery.domain.modal.PizzaModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PizzaDeliveryRepositoryImpl @Inject constructor(
    private val pizzaIpi: PizzaApi
): PizzaDeliveryRepository {

    override suspend fun getPizzaMenu(): List<PizzaModelItem> = withContext(Dispatchers.IO) {
        pizzaIpi.getPizzaMenu()
    }

    override suspend fun getSaleBanner(): List<BannersItem> = listOf(
        BannersItem(
            name = "saleBanner",
            icon = R.drawable.bingo_pizza
        ),
        BannersItem(
            name = "deliveryBanner",
            icon = R.drawable.pizza_delivery_baner
        )
    )
}