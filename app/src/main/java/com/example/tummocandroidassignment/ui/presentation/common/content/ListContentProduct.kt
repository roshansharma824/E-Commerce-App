package com.example.tummocandroidassignment.ui.presentation.common.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.tummocandroidassignment.R
import androidx.navigation.compose.rememberNavController
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.presentation.common.card.ProductCard
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.Green
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_12sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_24sp

@Composable
fun ListContentProduct(
    modifier: Modifier = Modifier,
    title: String,
    products: List<ProductItem>,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit,
    onClickToFavorite: (ProductItem) ->Unit,
    onClickDeleteFavorite: (ProductItem) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = DIMENS_16dp, end = DIMENS_16dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_24sp,
                color = Black
            )
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = stringResource(id = R.string.see_all),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_12sp,
                color = Green
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(DIMENS_16dp),
            contentPadding = PaddingValues(DIMENS_16dp)
        ) {
            items(products) { product ->
                ProductCard(
                    productItem = product,
                    navController = navController,
                    onClickToCart = onClickToCart,
                    onClickToFavorite = onClickToFavorite,
                    onClickDeleteFavorite = onClickDeleteFavorite
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListContentProductPreview() {
    ListContentProduct(
        title = "Exclusive Offer",
        products = listOf(
            ProductItem(
                id = 1,
                name = "Organic Bananas",
                icon = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
                unit = "7pcs, Priceg",
                price = 4.99,
                nutritions = "100gr",
                review = 4.0,
                categories = "Food"
            ),
            ProductItem(
                id = 1,
                name = "Organic Bananas",
                icon = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
                unit = "7pcs, Priceg",
                price = 4.99,
                nutritions = "100gr",
                review = 4.0,
                categories = "Food"
            ),
            ProductItem(
                id = 1,
                name = "Organic Bananas",
                icon = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
                unit = "7pcs, Priceg",
                price = 4.99,
                nutritions = "100gr",
                review = 4.0,
                categories = "Food"
            )
        ),
        navController = rememberNavController(),
        onClickToCart = {},
        onClickToFavorite = {},
        onClickDeleteFavorite = {},
    )
}