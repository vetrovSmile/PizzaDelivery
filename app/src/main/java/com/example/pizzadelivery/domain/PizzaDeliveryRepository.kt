package com.example.pizzadelivery.domain

import com.example.pizzadelivery.domain.modal.PizzaModelItem

interface PizzaDeliveryRepository {

    suspend fun getPizzaMenu(): List<PizzaModelItem>

    suspend fun getSaleBanner(): List<BannersItem>

}