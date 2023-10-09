package com.example.tummocandroidassignment.ui.domain.usecase.deletecartusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem

class DeleteCartUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.deleteCart(productItem)

}