package com.example.pizzadelivery.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDao {

    @Query("SELECT * FROM pizza_db")
    fun getPizzasFlowable(): Flow<List<PizzaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizzaEntity(pizzaModalEntity: PizzaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizzaEntities(pizzaModalEntities: List<PizzaEntity>)
}