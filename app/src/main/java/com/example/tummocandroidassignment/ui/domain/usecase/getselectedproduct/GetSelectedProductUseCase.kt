package com.example.tummocandroidassignment.ui.domain.usecase.getselectedproduct

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem

class GetSelectedProductUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productId: Int): ProductItem {
        return repository.getSelectedProduct(productId = productId)
    }

}