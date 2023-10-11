package com.example.tummocandroidassignment.ui.data.repository

import com.example.tummocandroidassignment.ui.data.local.ProductDatabase
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    productDatabase: ProductDatabase
) : LocalDataSource {

    private val productDao = productDatabase.productDao()

    override suspend fun insertProducts(products: List<ProductItem>) =
        productDao.insertProducts(products)

    override fun getAllProduct(): Flow<List<ProductItem>> = productDao.getAllProducts()

    override suspend fun getSelectedProduct(productId: Int): ProductItem =
        productDao.getSelectedProduct(productId = productId)

    override fun getAllProductCart(isCart: Boolean): Flow<List<ProductItem>> =
        productDao.getAllProductCart(isCart)

    override fun getAllProductFavorite(isFavorite: Boolean): Flow<List<ProductItem>> =
        productDao.getAllProductFavorite(isFavorite)


    override suspend fun addCart(productItem: ProductItem) = productDao.addCart(productItem)

    override suspend fun addFavorite(productItem: ProductItem) = productDao.addFavorite(productItem)

    override suspend fun deleteCart(productItem: ProductItem) {
        productItem.isCart = false
        productDao.deleteCart(productItem)
    }

    override suspend fun deleteFavorite(productItem: ProductItem) {
        productItem.isFavorite = false
        productDao.deleteFavorite(productItem)
    }

    override fun searchProduct(query: String): Flow<List<ProductItem>> =
        productDao.searchProduct(query)

}