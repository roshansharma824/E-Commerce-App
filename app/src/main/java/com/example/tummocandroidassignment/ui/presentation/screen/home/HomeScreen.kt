package com.example.tummocandroidassignment.ui.presentation.screen.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tummocandroidassignment.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.presentation.common.content.ListContentProduct
import com.example.tummocandroidassignment.ui.presentation.component.SliderBanner
import com.example.tummocandroidassignment.ui.theme.DIMENS_24dp
import com.example.tummocandroidassignment.ui.theme.Green

@ExperimentalPagerApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val mContext = LocalContext.current
    val searchQuery by homeViewModel.searchQuery
    val allProducts by homeViewModel.productList.collectAsState()
    val allFoodProducts by homeViewModel.foodProductList.collectAsState()
    val allBeveragesProducts by homeViewModel.beveragesProductList.collectAsState()
    val allHygieneEssentialsProducts by homeViewModel.hygieneEssentialsProductList.collectAsState()
    val allPoojaDailyNeedsProducts by homeViewModel.poojaDailyNeedsProductList.collectAsState()
    val allElectronicItemsProducts by homeViewModel.electronicItemsProductList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent,
                elevation = 0.dp,
                title = {
                    Text(
                        text = stringResource(id = R.string.home),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                },
                modifier = Modifier.background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Cyan,
                            Green
                        )
                    )
                ),
            )
        },
    ) { padding ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            Spacer(modifier = Modifier.height(DIMENS_24dp))

            SliderBanner()

            ListContentProduct(title = stringResource(id = R.string.food),
                products = allFoodProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                },
                onClickToFavorite = { productItem ->
                    clickToFavorite(
                        mContext, productItem, homeViewModel
                    )
                },
                onClickDeleteFavorite = { productItem ->
                    clickDeleteFavorite(
                        mContext, productItem, homeViewModel
                    )
                })

            Spacer(modifier = Modifier.height(DIMENS_24dp))

            ListContentProduct(title = stringResource(id = R.string.beverages),
                products = allBeveragesProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                },
                onClickToFavorite = { productItem ->
                    clickToFavorite(
                        mContext, productItem, homeViewModel
                    )
                },
                onClickDeleteFavorite = { productItem ->
                    clickDeleteFavorite(
                        mContext, productItem, homeViewModel
                    )
                })
            Spacer(modifier = Modifier.height(DIMENS_24dp))

            ListContentProduct(title = stringResource(id = R.string.hygiene_essentials),
                products = allHygieneEssentialsProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                },
                onClickToFavorite = { productItem ->
                    clickToFavorite(
                        mContext, productItem, homeViewModel
                    )
                },
                onClickDeleteFavorite = { productItem ->
                    clickDeleteFavorite(
                        mContext, productItem, homeViewModel
                    )
                })

            Spacer(modifier = Modifier.height(DIMENS_24dp))

            ListContentProduct(title = stringResource(id = R.string.pooja_daily_needs),
                products = allPoojaDailyNeedsProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                },
                onClickToFavorite = { productItem ->
                    clickToFavorite(
                        mContext, productItem, homeViewModel
                    )
                },
                onClickDeleteFavorite = { productItem ->
                    clickDeleteFavorite(
                        mContext, productItem, homeViewModel
                    )
                })

            Spacer(modifier = Modifier.height(DIMENS_24dp))

            ListContentProduct(title = stringResource(id = R.string.electronic_items),
                products = allElectronicItemsProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                },
                onClickToFavorite = { productItem ->
                    clickToFavorite(
                        mContext, productItem, homeViewModel
                    )
                },
                onClickDeleteFavorite = { productItem ->
                    clickDeleteFavorite(
                        mContext, productItem, homeViewModel
                    )
                })
        }
    }
}

@Composable
fun HeaderLocationHome(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(DIMENS_24dp))

    }
}

fun clickToCart(context: Context, productItem: ProductItem, viewModel: HomeViewModel) {
    viewModel.addCart(productItem.copy(isCart = true))
}

fun clickToFavorite(context: Context, productItem: ProductItem, viewModel: HomeViewModel) {
    viewModel.addFavorite(productItem.copy(isFavorite = true))
}

fun clickDeleteFavorite(context: Context, productItem: ProductItem, viewModel: HomeViewModel) {
    viewModel.deleteFavorite(productItem.copy(isFavorite = true))
}

@Preview(showBackground = true)
@Composable
fun HeaderLocationHomePreview() {
    HeaderLocationHome()
}