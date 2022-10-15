package com.example.pizzadelivery.di

import android.content.Context
import androidx.room.Room
import com.example.pizzadelivery.data.database.PizzaDeliveryDataBase
import com.example.pizzadelivery.data.database.PizzaDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): PizzaDeliveryDataBase {
        return Room.databaseBuilder(
            context,
            PizzaDeliveryDataBase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(dataBase: PizzaDeliveryDataBase): PizzaDao {
        return dataBase.pizzaDao()
    }

    companion object {
        private const val DB_NAME = "pizza_Db_name"
    }
}