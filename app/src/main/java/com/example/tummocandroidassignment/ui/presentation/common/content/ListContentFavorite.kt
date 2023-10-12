package com.example.tummocandroidassignment.ui.presentation.common.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.presentation.common.card.FavoriteCard
import com.example.tummocandroidassignment.ui.theme.DIMENS_32dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_8dp

@Composable
fun ListContentFavorite(
    modifier: Modifier = Modifier,
    favoriteProducts: List<ProductItem>,
    onClickDeleteFavorite: (ProductItem) -> Unit,
    onClickToCart: (ProductItem) -> Unit,
) {
    if (favoriteProducts.isNotEmpty()) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = DIMENS_32dp),
            verticalArrangement = Arrangement.spacedBy(DIMENS_8dp)
        ) {
            items(favoriteProducts) { items ->
                FavoriteCard(productItem = items,
                    onClickDeleteFavorite = { productItem ->
                        onClickDeleteFavorite.invoke(productItem)
                    },
                    onClickToCart = { productItem ->
                        onClickToCart.invoke(productItem)
                    }
                )
            }
        }
    } else {
        EmptyContent()
    }
}

@Preview(showBackground = true)
@Composable
fun ListContentFavoritePreview() {
    ListContentFavorite(favoriteProducts = emptyList(), onClickDeleteFavorite = {},onClickToCart={})
}