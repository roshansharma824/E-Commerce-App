package com.example.tummocandroidassignment.ui.presentation.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.presentation.common.card.FavoriteCard
import com.example.tummocandroidassignment.ui.presentation.common.content.ListContentCart
import com.example.tummocandroidassignment.ui.presentation.common.content.ListContentFavorite
import com.example.tummocandroidassignment.ui.presentation.component.SearchViewBar
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.DIMENS_10dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_18sp
import com.example.tummocandroidassignment.ui.utils.DataDummy

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    favoriteViewModel: FavoriteViewModel = hiltViewModel()
) {
    val productFavoriteList by favoriteViewModel.productFavoriteList.collectAsState()
    Scaffold { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = DIMENS_16dp),
                text = stringResource(R.string.favorite),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = TEXT_SIZE_18sp,
                color = Black
            )



            Spacer(modifier = Modifier.height(DIMENS_16dp))

            ListContentFavorite(
                favoriteProducts = productFavoriteList,
                onClickDeleteFavorite = { productItem ->
                    favoriteViewModel.deleteFavorite(productItem.copy(isFavorite = false))
                }
            )
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview() {

}