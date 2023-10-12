package com.example.tummocandroidassignment.ui.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.domain.usecase.UseCases
import com.example.tummocandroidassignment.ui.utils.Categories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _productList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productList = _productList.asStateFlow()

    private val _foodProductList = MutableStateFlow<List<ProductItem>>(emptyList())
    val foodProductList = _foodProductList.asStateFlow()

    private val _beveragesProductList = MutableStateFlow<List<ProductItem>>(emptyList())
    val beveragesProductList = _beveragesProductList.asStateFlow()

    private val _hygieneEssentialsProductList = MutableStateFlow<List<ProductItem>>(emptyList())
    val hygieneEssentialsProductList = _hygieneEssentialsProductList.asStateFlow()

    private val _poojaDailyNeedsProductList = MutableStateFlow<List<ProductItem>>(emptyList())
    val poojaDailyNeedsProductList = _poojaDailyNeedsProductList.asStateFlow()

    private val _electronicItemsProductList = MutableStateFlow<List<ProductItem>>(emptyList())
    val electronicItemsProductList = _electronicItemsProductList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllProductUseCase.invoke().collect { value ->
                _productList.value = value
                val food: ArrayList<ProductItem> = arrayListOf<ProductItem>()
                val beverages: ArrayList<ProductItem> = arrayListOf<ProductItem>()
                val hygieneEssentials: ArrayList<ProductItem> = arrayListOf<ProductItem>()
                val poojaDailyNeeds: ArrayList<ProductItem> = arrayListOf<ProductItem>()
                val electronicItems: ArrayList<ProductItem> = arrayListOf<ProductItem>()

                for (product in value) {

                    when (product.categories) {
                        Categories.Food.printableName -> {
                            food.add(product)
                        }

                        Categories.Beverages.printableName -> {
                            beverages.add(product)
                        }

                        Categories.HygieneEssentials.printableName -> {
                            hygieneEssentials.add(product)
                        }

                        Categories.PoojaDailyNeeds.printableName -> {
                            poojaDailyNeeds.add(product)
                        }

                        Categories.ElectronicItems.printableName -> {
                            electronicItems.add(product)
                        }
                    }
                }
                _foodProductList.value = food
                _beveragesProductList.value = beverages
                _hygieneEssentialsProductList.value = hygieneEssentials
                _poojaDailyNeedsProductList.value = poojaDailyNeeds
                _electronicItemsProductList.value = electronicItems
            }
        }
    }

    fun addCart(productItem: ProductItem) = viewModelScope.launch {
        useCases.addCartUseCase.invoke(productItem)
    }

    fun addFavorite(productItem: ProductItem) = viewModelScope.launch {
        useCases.addFavoriteUseCase.invoke(productItem)
    }

    fun deleteFavorite(productItem: ProductItem) = viewModelScope.launch {
        useCases.deleteFavorite.invoke(productItem)
    }

}