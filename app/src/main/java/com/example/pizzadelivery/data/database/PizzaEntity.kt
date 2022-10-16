package com.example.pizzadelivery.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pizzadelivery.domain.modal.PizzaData
import com.example.pizzadelivery.domain.modal.PizzaModel

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
) {
    companion object {
        infix fun from(pizzaModel: PizzaModel): PizzaEntity {
            return PizzaEntity(
                id = pizzaModel.id,
                country = pizzaModel.country,
                description = pizzaModel.description,
                image = pizzaModel.image,
                name = pizzaModel.name,
                price = pizzaModel.price,
                rate = pizzaModel.rate
            )
        }
    }
}
