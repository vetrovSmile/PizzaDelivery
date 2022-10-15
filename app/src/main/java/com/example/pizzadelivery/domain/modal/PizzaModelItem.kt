package com.example.pizzadelivery.domain.modal

data class PizzaModelItem(
    val country: String,
    val dsc: String,
    val id: String,
    val img: String,
    val name: String,
    val price: Double,
    val rate: Int
)