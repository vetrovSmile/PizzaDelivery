package com.example.pizzadelivery.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza_db")
data class PizzaEntity(
    @PrimaryKey
    val id: String,
    val country: String,
    val description: String,
    val image: String,
    val name: String,
    val price: Double,
    val rate: Int
)
