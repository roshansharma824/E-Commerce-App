package com.example.tummocandroidassignment.ui.domain.repository

import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.domain.usecase.addfavoriteusecase.AddFavoriteUseCase
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertProducts(products: List<ProductItem>)
    fun getAllProduct(): Flow<List<ProductItem>>
    suspend fun getSelectedProduct(productId: Int): ProductItem
    fun getAllProductCart(isCart: Boolean): Flow<List<ProductItem>>
    fun getAllProductFavorite(isFavorite: Boolean): Flow<List<ProductItem>>
    suspend fun addCart(productItem: ProductItem)
    suspend fun addFavorite(productItem: ProductItem)
    suspend fun deleteCart(productItem: ProductItem)
    suspend fun deleteFavorite(productItem: ProductItem)
    fun searchProduct(query: String): Flow<List<ProductItem>>
}