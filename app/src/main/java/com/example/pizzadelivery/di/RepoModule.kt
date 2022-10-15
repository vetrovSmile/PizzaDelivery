package com.example.pizzadelivery.di

import com.example.pizzadelivery.data.PizzaDeliveryRepositoryImpl
import com.example.pizzadelivery.domain.PizzaDeliveryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun bindRepository(pizzaDeliveryRepositoryImpl: PizzaDeliveryRepositoryImpl): PizzaDeliveryRepository
}