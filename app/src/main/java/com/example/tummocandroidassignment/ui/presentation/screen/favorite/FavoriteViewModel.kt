package com.example.tummocandroidassignment.ui.presentation.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val isFavorite = true

    private val _productFavoriteList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productFavoriteList = _productFavoriteList.asStateFlow()

    init {
        getAllProductFavorite()
    }

    private fun getAllProductFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllProductFavoriteUseCase.invoke(isFavorite).collect { values ->
                _productFavoriteList.value = values
            }
        }
    }

    fun deleteFavorite(productItem: ProductItem) {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.deleteFavorite.invoke(productItem)
        }
    }

}