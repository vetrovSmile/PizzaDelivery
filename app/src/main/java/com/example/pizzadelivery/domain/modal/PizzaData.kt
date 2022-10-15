package com.example.pizzadelivery.domain.modal

import com.example.pizzadelivery.data.database.PizzaEntity

data class PizzaData(
    val id: String,
    val country: String,
    val description: String,
    val image: String,
    val name: String,
    val price: Double,
    val rate: Int
) {
    companion object {
        infix fun from(pizzaModel: PizzaModel): PizzaData {
            return PizzaData(
                id = pizzaModel.id,
                country = pizzaModel.country,
                description = pizzaModel.description,
                image = pizzaModel.image,
                name = pizzaModel.name,
                price = pizzaModel.price,
                rate = pizzaModel.rate
            )
        }

        infix fun from(pizzaEntity: PizzaEntity): PizzaData {
            return PizzaData(
                id = pizzaEntity.id,
                country = pizzaEntity.country,
                description = pizzaEntity.description,
                image = pizzaEntity.image,
                name = pizzaEntity.name,
                price = pizzaEntity.price,
                rate = pizzaEntity.rate
            )
        }
    }
}
