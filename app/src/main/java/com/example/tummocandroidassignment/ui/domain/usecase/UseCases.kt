package com.example.tummocandroidassignment.ui.domain.usecase

import com.example.tummocandroidassignment.ui.domain.usecase.addcartusecase.AddCartUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.addfavoriteusecase.AddFavoriteUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.deletecartusecase.DeleteCartUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.deletefavoriteusecase.DeleteFavoriteUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.getallcartusecase.GetAllCartUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.getallproduct.GetAllProductUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.getallproductfavoriteusecase.GetAllProductFavoriteUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.getselectedproduct.GetSelectedProductUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.readonboarding.ReadOnBoardingUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.saveonboarding.SaveOnBoardingUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.saveproductusecase.InsertProductsUseCase
import com.example.tummocandroidassignment.ui.domain.usecase.searchproductusecase.SearchProductUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val insertProductsUseCase: InsertProductsUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getSelectedProductUseCase: GetSelectedProductUseCase,
    val getAllProductUseCase: GetAllProductUseCase,
    val getAllCartUseCase: GetAllCartUseCase,
    val addCartUseCase: AddCartUseCase,
    val deleteCart: DeleteCartUseCase,
    val deleteFavorite: DeleteFavoriteUseCase,
    val searchProductUseCase: SearchProductUseCase,
    val addFavoriteUseCase: AddFavoriteUseCase,
    val getAllProductFavoriteUseCase: GetAllProductFavoriteUseCase,
)