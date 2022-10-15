package com.example.pizzadelivery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PizzaEntity::class],
    version = 1
)
abstract class PizzaDeliveryDataBase : RoomDatabase() {

    abstract fun pizzaDao(): PizzaDao
}