package com.example.tummocandroidassignment.ui.domain.usecase.addfavoriteusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.model.ProductItem

class AddFavoriteUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(productItem: ProductItem) = repository.addFavorite(productItem)

}