package com.example.tummocandroidassignment.ui.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.tummocandroidassignment.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.presentation.common.card.FavoriteCard
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_1dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_32dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_4dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_64dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_8dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.GrayBorderStroke
import com.example.tummocandroidassignment.ui.theme.GraySecondTextColor
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_12sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_16sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_18sp

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