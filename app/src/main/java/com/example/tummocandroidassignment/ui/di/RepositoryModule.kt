package com.example.tummocandroidassignment.ui.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.tummocandroidassignment.ui.data.repository.OnBoardingOperationImpl
import com.example.tummocandroidassignment.ui.data.repository.Repository
import com.example.tummocandroidassignment.ui.domain.repository.OnBoardingOperations
import com.example.tummocandroidassignment.ui.domain.usecase.UseCases
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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context
    ): OnBoardingOperations = OnBoardingOperationImpl(context = context)

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            insertProductsUseCase = InsertProductsUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getSelectedProductUseCase = GetSelectedProductUseCase(repository),
            getAllProductUseCase = GetAllProductUseCase(repository),
            getAllCartUseCase = GetAllCartUseCase(repository),
            addCartUseCase = AddCartUseCase(repository),
            addFavoriteUseCase = AddFavoriteUseCase(repository),
            deleteCart = DeleteCartUseCase(repository),
            searchProductUseCase = SearchProductUseCase(repository),
            getAllProductFavoriteUseCase = GetAllProductFavoriteUseCase(repository),
            deleteFavorite = DeleteFavoriteUseCase(repository),
        )
    }

}