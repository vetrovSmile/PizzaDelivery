package com.example.pizzadelivery.domain

import com.example.pizzadelivery.domain.modal.BannersModel
import com.example.pizzadelivery.domain.modal.PizzaData
import kotlinx.coroutines.flow.Flow

interface PizzaDeliveryRepository {
    suspend fun getSaleBanner(): List<BannersModel>
    suspend fun requestPizzaMenu()
    fun pizzaMenuFlowable(): Flow<List<PizzaData>>
}