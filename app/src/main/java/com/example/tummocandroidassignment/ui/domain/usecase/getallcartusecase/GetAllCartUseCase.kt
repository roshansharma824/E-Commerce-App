package com.example.tummocandroidassignment.ui.domain.usecase.getallcartusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllCartUseCase(
    private val repository: Repository
) {

    operator fun invoke(isCart: Boolean): Flow<List<ProductItem>> =
        repository.getAllProductCart(isCart)

}