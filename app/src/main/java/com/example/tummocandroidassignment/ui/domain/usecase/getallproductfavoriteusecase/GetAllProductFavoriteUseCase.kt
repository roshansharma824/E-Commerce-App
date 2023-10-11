package com.example.tummocandroidassignment.ui.domain.usecase.getallproductfavoriteusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import kotlinx.coroutines.flow.Flow

class GetAllProductFavoriteUseCase(
    private val repository: Repository
) {

    operator fun invoke(isFavorite:Boolean): Flow<List<ProductItem>> =
        repository.getAllProductFavorite(isFavorite)

}