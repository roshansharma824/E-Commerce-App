package com.example.tummocandroidassignment.ui.presentation.common.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.presentation.common.rememberCheckIndeterminateSmall
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.*
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_24dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_32dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_4dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_64dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_68dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_6dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_80dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_8dp
import com.example.tummocandroidassignment.ui.theme.EComFontFamily
import com.example.tummocandroidassignment.ui.theme.GrayBorderStroke
import com.example.tummocandroidassignment.ui.theme.GraySecondTextColor
import com.example.tummocandroidassignment.ui.theme.Green
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_12sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_16sp

@Composable
fun ListContentCart(
    modifier: Modifier = Modifier,
    cartProducts: List<ProductItem>,
    onClickDeleteCart: (ProductItem) -> Unit,
    onClickToCart: (ProductItem) -> Unit,
) {
    if (cartProducts.isNotEmpty()) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(top = DIMENS_32dp),
            verticalArrangement = Arrangement.spacedBy(DIMENS_8dp)
        ) {
            items(cartProducts) { items ->
                ContentCart(productItem = items, onClickDeleteCart = { productItem ->
                    onClickDeleteCart.invoke(productItem)
                }, onClickToCart = { productItem ->
                    onClickToCart.invoke(productItem)
                })
            }
        }
    } else {
        EmptyContent()
    }
}

@Composable
fun ContentCart(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    onClickDeleteCart: (ProductItem) -> Unit,
    onClickToCart: (ProductItem) -> Unit,
) {
    Card(shape = RoundedCornerShape(DIMENS_12dp),
        border = BorderStroke(width = 1.dp, color = GrayBorderStroke),
        elevation = DIMENS_6dp,
        modifier = modifier
            .padding(start = DIMENS_16dp, end = DIMENS_16dp, bottom = DIMENS_16dp)
            .clickable {
//                navController.navigate(Screen.Details.passProductId(productId = productItem.id))
            }) {
        Column(
            modifier = modifier
                .background(Color.White)
                .padding(DIMENS_16dp)
                .fillMaxWidth()
                .height(DIMENS_68dp)
        ) {

            Row(
                modifier = modifier.fillMaxWidth()

            ) {
                Image(
                    modifier = Modifier
                        .size(width = DIMENS_64dp, height = DIMENS_64dp)
                        .padding(start = DIMENS_8dp),
                    painter = rememberAsyncImagePainter(productItem.icon),
                    contentDescription = stringResource(id = R.string.image_product)
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(start = DIMENS_16dp),
                ) {
                    Text(
                        text = productItem.name,
                        fontFamily = EComFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        fontSize = TEXT_SIZE_16sp
                    )

                    Spacer(modifier = Modifier.height(DIMENS_4dp))

                    Text(
                        text = "₹${productItem.price}",
                        fontFamily = EComFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = GraySecondTextColor,
                        fontSize = TEXT_SIZE_12sp,
                    )
                }

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                ) {

                    Row(
                        modifier = Modifier.width(DIMENS_80dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(modifier = Modifier.size(DIMENS_24dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                            shape = RoundedCornerShape(DIMENS_6dp),
                            contentPadding = PaddingValues(DIMENS_4dp),
                            onClick = {
                                onClickDeleteCart.invoke(productItem)
                            }) {
                            Icon(
                                modifier = Modifier.fillMaxSize(),
                                imageVector = rememberCheckIndeterminateSmall(),
                                tint = Color.White,
                                contentDescription = stringResource(id = R.string.add)
                            )
                        }
                        Text(
                            text = "${productItem.quantity}",
                            fontFamily = EComFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Black,
                            fontSize = TEXT_SIZE_12sp,
                        )
                        Button(modifier = Modifier.size(DIMENS_24dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                            shape = RoundedCornerShape(DIMENS_6dp),
                            contentPadding = PaddingValues(DIMENS_4dp),
                            onClick = {
                                onClickToCart.invoke(productItem)
                            }) {
                            Icon(
                                modifier = Modifier.fillMaxSize(),
                                imageVector = Icons.Default.Add,
                                tint = Color.White,
                                contentDescription = stringResource(id = R.string.add)
                            )
                        }
                    }





                    Text(
                        text = "₹${productItem.price}",
                        fontFamily = EComFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        fontSize = TEXT_SIZE_12sp,
                        modifier = Modifier.padding(top = DIMENS_32dp)
                    )
                }


            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ContentCartPreview() {
    ContentCart(productItem = ProductItem(
        id = 1,
        name = "Organic Bananas",
        icon = "https://cdn-icons-png.flaticon.com/128/3659/3659899.png",
        unit = "7pcs, Priceg",
        price = 4.99,
        nutritions = "100gr",
        review = 4.0,
        categories = "Food"
    ), onClickDeleteCart = {}, onClickToCart = {})
}

@Preview(showBackground = true)
@Composable
fun ListContentCartPreview() {
    ListContentCart(
        cartProducts = emptyList(),
        onClickDeleteCart = {},
        onClickToCart = {},
    )
}


