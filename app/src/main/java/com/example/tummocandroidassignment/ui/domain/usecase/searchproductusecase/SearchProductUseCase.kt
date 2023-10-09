package com.example.tummocandroidassignment.ui.domain.usecase.searchproductusecase

import com.example.tummocandroidassignment.ui.data.repository.Repository

class SearchProductUseCase(
    private val repository: Repository
) {

    operator fun invoke(query: String) = repository.searchProduct(query)

}