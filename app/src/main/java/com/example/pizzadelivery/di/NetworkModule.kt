package com.example.pizzadelivery.di

import com.example.pizzadelivery.data.network.PizzaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesPizzaApi(): PizzaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PizzaApi::class.java)
    }

    companion object {
        // FIXME: move to build config
        private const val BASE_URL = "https://ig-food-menus.herokuapp.com/"
    }
}