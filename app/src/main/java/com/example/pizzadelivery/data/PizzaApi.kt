package com.example.pizzadelivery.data

import com.example.pizzadelivery.domain.modal.PizzaModelItem
import retrofit2.http.GET

interface PizzaApi {

    @GET("pizzas")
    suspend fun getPizzaMenu(): List<PizzaModelItem>

}