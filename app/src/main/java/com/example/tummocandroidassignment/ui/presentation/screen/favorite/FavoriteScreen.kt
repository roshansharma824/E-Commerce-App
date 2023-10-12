package com.example.tummocandroidassignment.ui.presentation.screen.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.presentation.common.content.ListContentFavorite
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.Green

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {
    val productFavoriteList by favoriteViewModel.productFavoriteList.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent,
                elevation = 0.dp,
                title = {
                    Text(
                        text = stringResource(id = R.string.favorite),
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
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {




            Spacer(modifier = Modifier.height(DIMENS_16dp))

            ListContentFavorite(

                favoriteProducts = productFavoriteList,
                onClickDeleteFavorite = { productItem ->
                    favoriteViewModel.deleteFavorite(productItem.copy(isFavorite = false))
                },
                onClickToCart = { productItem ->
                    favoriteViewModel.addCart(productItem.copy(isCart = true))
                }
            )
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview() {

}