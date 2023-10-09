package com.example.tummocandroidassignment.ui.domain.usecase.addcartusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem

class AddCartUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.addCart(productItem)

}