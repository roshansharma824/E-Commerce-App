package com.example.tummocandroidassignment.ui.domain.usecase.saveproductusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem

class InsertProductsUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(products: List<ProductItem>) = repository.insertProducts(products)

}