package com.example.tummocandroidassignment.ui.presentation.screen.home

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.tummocandroidassignment.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.navigation.screen.Screen
import com.example.tummocandroidassignment.ui.presentation.common.content.ListContentProduct
import com.example.tummocandroidassignment.ui.presentation.component.SearchViewBar
import com.example.tummocandroidassignment.ui.presentation.component.SliderBanner
import com.example.tummocandroidassignment.ui.theme.DIMENS_24dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_8dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.GrayThirdTextColor
import com.example.tummocandroidassignment.ui.theme.Green
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_12sp
import com.example.tummocandroidassignment.ui.utils.showToastShort

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

    Scaffold(
        topBar = {
            // inside top bar we are specifying background color.
            TopAppBar(backgroundColor = Green,
                // along with that we are specifying title for our top bar.
                title = {
                    // in the top bar we are specifying tile as a text
                    Text(
                        // on below line we are specifying
                        // text to display in top app bar.
                        text = "Home",

                        // on below line we are specifying
                        // modifier to fill max width.
                        modifier = Modifier.fillMaxWidth(),

                        // on below line we are
                        // specifying text alignment.
                        textAlign = TextAlign.Center,

                        // on below line we are
                        // specifying color for our text.
                        color = Color.White
                    )
                }
            )
        } ,
    ) { padding ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            HeaderLocationHome()

            SearchViewBar(
                hint = stringResource(id = R.string.search_store),
                query = searchQuery,
                onValueChange = {
                    if (it.isNotEmpty()) navController.navigate(Screen.Search.route)
                }
            )

            SliderBanner()

            ListContentProduct(
                title = stringResource(id = R.string.exclusive_offer),
                products = allProducts,
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                },
                onClickToFavorite = { productItem ->
                    clickToFavorite(
                        mContext,
                        productItem,
                        homeViewModel
                    )
                },
                onClickDeleteFavorite = { productItem ->
                    clickDeleteFavorite(
                        mContext,
                        productItem,
                        homeViewModel
                    )
                }
            )

            Spacer(modifier = Modifier.height(DIMENS_24dp))

            ListContentProduct(
                title = stringResource(id = R.string.best_selling),
                products = allProducts.sortedByDescending { it.id },
                navController = navController,
                onClickToCart = { productItem ->
                    clickToCart(mContext, productItem, homeViewModel)
                },
                onClickToFavorite = { productItem ->
                    clickToFavorite(
                        mContext,
                        productItem,
                        homeViewModel
                    )
                },
                onClickDeleteFavorite = { productItem ->
                    clickDeleteFavorite(
                        mContext,
                        productItem,
                        homeViewModel
                    )
                }
            )
        }
    }
}

@Composable
fun HeaderLocationHome(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(DIMENS_24dp))

        Icon(
            modifier = Modifier
                .size(DIMENS_24dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.ic_nectar),
            contentDescription = stringResource(id = R.string.logo_app),
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.height(DIMENS_8dp))

        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = stringResource(R.string.image_location),
                tint = GrayThirdTextColor
            )
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = stringResource(R.string.sample_country),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_12sp,
                color = GrayThirdTextColor
            )
        }
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