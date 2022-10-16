package com.example.pizzadelivery.data

import com.example.pizzadelivery.R
import com.example.pizzadelivery.data.database.PizzaDao
import com.example.pizzadelivery.data.database.PizzaEntity
import com.example.pizzadelivery.data.network.PizzaApi
import com.example.pizzadelivery.domain.modal.BannersModel
import com.example.pizzadelivery.domain.PizzaDeliveryRepository
import com.example.pizzadelivery.domain.modal.PizzaData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PizzaDeliveryRepositoryImpl @Inject constructor(
    private val pizzaApi: PizzaApi,
    private val pizzaDao: PizzaDao,
) : PizzaDeliveryRepository {

    override suspend fun requestPizzaMenu() = withContext(Dispatchers.IO) {
        val pizzaModels = pizzaApi.getPizzaMenu()
        pizzaDao.insertPizzaEntities(
            pizzaModels.map { pizzaModel ->
                PizzaEntity from pizzaModel
            }
        )
    }

    override fun pizzaMenuFlowable(): Flow<List<PizzaData>> {
        return pizzaDao.getPizzasFlowable().map { pizzaEntities ->
            pizzaEntities.map { pizzaEntity ->
                PizzaData from pizzaEntity
            }
        }
    }

    override suspend fun getSaleBanner(): List<BannersModel> = listOf(
        BannersModel(
            name = "saleBanner",
            icon = R.drawable.bingo_pizza
        ),
        BannersModel(
            name = "deliveryBanner",
            icon = R.drawable.pizza_delivery_baner
        )
    )
}

