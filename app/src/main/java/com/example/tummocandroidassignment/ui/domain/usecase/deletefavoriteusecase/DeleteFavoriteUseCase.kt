package com.example.tummocandroidassignment.ui.domain.usecase.deletefavoriteusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem

class DeleteFavoriteUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.deleteFavorite(productItem)

}