package com.example.tummocandroidassignment.ui.domain.usecase.getallproduct

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllProductUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<List<ProductItem>> = repository.getAllProduct()

}