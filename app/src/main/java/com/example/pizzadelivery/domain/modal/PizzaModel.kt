package com.example.pizzadelivery.domain.modal

import com.google.gson.annotations.SerializedName

data class PizzaModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("dsc")
    val description: String,
    @SerializedName("img")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("rate")
    val rate: Int
)