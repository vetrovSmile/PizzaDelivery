package com.example.pizzadelivery.data.network

import com.example.pizzadelivery.domain.modal.PizzaModel
import retrofit2.http.GET

interface PizzaApi {
    @GET("pizzas")
    suspend fun getPizzaMenu(): List<PizzaModel>
}