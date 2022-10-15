package com.example.pizzadelivery.data.database

import com.example.pizzadelivery.domain.modal.PizzaModel
import javax.inject.Inject

class PizzaModalMapper @Inject constructor() {

    private fun mapEntityToModel(dbModal: PizzaEntity): PizzaModel {
        return PizzaModel(
            id = dbModal.id,
            country = dbModal.country,
            description = dbModal.description,
            image = dbModal.image,
            name = dbModal.name,
            price = dbModal.price,
            rate = dbModal.rate
        )
    }

    fun mapModelToEntity(pizzaModel: PizzaModel): PizzaEntity {
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

    fun mapEntitiesToModals(list: List<PizzaEntity>): List<PizzaModel> {
        return list.map(::mapEntityToModel)
    }

    fun mapModelsToEntities(pizzaModels: List<PizzaModel>): List<PizzaEntity> {
        return pizzaModels.map(::mapModelToEntity)
    }
}
