package com.example.tummocandroidassignment.ui.presentation.screen.detail

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.presentation.common.SpacerDividerContent
import com.example.tummocandroidassignment.ui.presentation.common.card.FavoriteButton
import com.example.tummocandroidassignment.ui.presentation.component.RatingBar
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_1dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_24dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_353dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_4dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_6dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_8dp
import com.example.tummocandroidassignment.ui.theme.EComFontFamily
import com.example.tummocandroidassignment.ui.theme.GrayBackground
import com.example.tummocandroidassignment.ui.theme.GrayBackgroundSecond
import com.example.tummocandroidassignment.ui.theme.GraySecondTextColor
import com.example.tummocandroidassignment.ui.theme.Green
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_10sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_12sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_16sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_18sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_24sp
import com.example.tummocandroidassignment.ui.utils.showToastShort

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {
    val mContext = LocalContext.current
    val selectedProduct by detailViewModel.selectedProduct.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent,
                elevation = 0.dp,
                title = {
                    Text(
                        text = stringResource(id = R.string.detail),
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
        Column {
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .padding(padding)
            ) {
                selectedProduct?.let { productItem ->
                    DetailContentImageHeader(productItem = productItem)

                    Spacer(modifier = Modifier.height(DIMENS_24dp))

                    DetailContentDescription(productItem = productItem, onClickToFavorite = { productItem ->
                        clickToFavorite(
                            mContext,
                            productItem,
                            detailViewModel
                        )
                    },
                        onClickDeleteFavorite = { productItem ->
                            clickDeleteFavorite(
                                mContext,
                                productItem,
                                detailViewModel
                            )
                        })
                }
            }

            Column {
                selectedProduct?.let {
                    DetailButtonAddCart(
                        productItem = it,
                        onClickToCart = { productItem ->
                            mContext.showToastShort("Success Add To Cart ${productItem.name}")
                            detailViewModel.addCart(productItem.copy(isCart = true))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun DetailContentImageHeader(
    productItem: ProductItem
) {
    Card(
        shape = RoundedCornerShape(bottomEnd = DIMENS_24dp, bottomStart = DIMENS_24dp),
        backgroundColor = GrayBackground,
        modifier = Modifier
            .blur(DIMENS_1dp)
            .fillMaxWidth(),
    ) {
        Image(
            painter = rememberAsyncImagePainter(productItem.icon),
            contentDescription = stringResource(id = R.string.image_product),
            modifier = Modifier.height(DIMENS_353dp)
        )
    }
}

@Composable
fun DetailContentDescription(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    onClickToFavorite: (ProductItem) ->Unit,
    onClickDeleteFavorite: (ProductItem) -> Unit,
) {
    Column(
        modifier = modifier.padding(start = DIMENS_16dp, end = DIMENS_16dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = productItem.name,
                    fontFamily = EComFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    fontSize = TEXT_SIZE_24sp
                )

                Spacer(modifier = Modifier.height(DIMENS_6dp))

                Text(
                    text = productItem.unit,
                    fontFamily = EComFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = GraySecondTextColor,
                    fontSize = TEXT_SIZE_12sp,
                )
            }
            FavoriteButton(productItem = productItem, onClickToFavorite = onClickToFavorite , onClickDeleteFavorite = onClickDeleteFavorite )
        }

        Spacer(modifier = Modifier.height(DIMENS_8dp))

        Text(
            text = "₹${productItem.price}",
            fontFamily = EComFontFamily,
            fontWeight = FontWeight.Bold,
            color = Black,
            modifier = Modifier.align(Alignment.End),
            fontSize = TEXT_SIZE_18sp
        )

        SpacerDividerContent()

        Text(
            text = stringResource(R.string.product_detail),
            fontFamily = EComFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Black,
            fontSize = TEXT_SIZE_16sp,
        )

        Spacer(modifier = Modifier.height(DIMENS_8dp))

        Text(
            text = productItem.name,
            fontFamily = EComFontFamily,
            fontWeight = FontWeight.Medium,
            color = GraySecondTextColor,
            fontSize = TEXT_SIZE_12sp,
        )

        Spacer(modifier = Modifier.height(DIMENS_16dp))
        SpacerDividerContent()

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.nutritions),
                fontFamily = EComFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Black,
                fontSize = TEXT_SIZE_16sp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )

            Card(
                shape = RoundedCornerShape(DIMENS_6dp),
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = productItem.nutritions,
                    fontFamily = EComFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = GraySecondTextColor,
                    fontSize = TEXT_SIZE_10sp,
                    modifier = Modifier
                        .background(color = GrayBackgroundSecond)
                        .padding(DIMENS_4dp)
                )
            }

            Spacer(modifier = Modifier.width(DIMENS_8dp))

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.arrow_right)
            )
        }

        SpacerDividerContent()

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.review),
                fontFamily = EComFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Black,
                fontSize = TEXT_SIZE_16sp,
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )

            RatingBar(rating = productItem.review)

            Spacer(modifier = Modifier.width(DIMENS_8dp))

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.arrow_right)
            )
        }

    }
}

@Composable
fun DetailButtonAddCart(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    onClickToCart: (ProductItem) -> Unit
) {
    Button(
        shape = RoundedCornerShape(DIMENS_24dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Green),
        modifier = modifier
            .fillMaxWidth()
            .padding(DIMENS_16dp),
        onClick = { onClickToCart.invoke(productItem) }
    ) {
        Text(
            text = stringResource(R.string.add_to_cart),
            fontFamily = EComFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = TEXT_SIZE_18sp,
            color = Color.White,
            modifier = Modifier.padding(top = DIMENS_8dp, bottom = DIMENS_8dp)
        )
    }
}

fun clickToFavorite(context: Context, productItem: ProductItem, viewModel: DetailViewModel) {
    viewModel.addFavorite(productItem.copy(isFavorite = true))
}

fun clickDeleteFavorite(context: Context, productItem: ProductItem, viewModel: DetailViewModel) {
    viewModel.deleteFavorite(productItem.copy(isFavorite = true))
}


@Preview
@Composable
fun DetailScreenImageHeaderPreview() {
    DetailContentImageHeader(
        ProductItem(
            id = 1,
            name = "Organic Bananas",
            icon = "",
            unit = "7pcs, Priceg",
            price = 4.99,
            nutritions = "100gr",
            review = 4.0,
            categories = ""
        )
    )
}

@Preview
@Composable
fun DetailContentDescriptionPreview() {
    DetailContentDescription(
        productItem =
        ProductItem(
            id = 1,
            name = "Organic Bananas",
            icon = "",
            unit = "7pcs, Priceg",
            price = 4.99,
            nutritions = "100gr",
            review = 4.0,
            categories = ""
        ),
        onClickDeleteFavorite = {},
        onClickToFavorite = {}
    )
}