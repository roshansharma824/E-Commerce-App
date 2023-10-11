package com.example.tummocandroidassignment.ui.presentation.common.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.navigation.screen.Screen
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.DIMENS_108dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_10dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_12dp
import com.example.tummocandroidassignment.ui.theme.*
import com.example.tummocandroidassignment.ui.theme.DIMENS_174dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_20dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_24dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_46dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_4dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_6dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_80dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.GrayBorderStroke
import com.example.tummocandroidassignment.ui.theme.GraySecondTextColor
import com.example.tummocandroidassignment.ui.theme.Green
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_12sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_16sp
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_18sp

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    navController: NavController,
    onClickToCart: (ProductItem) -> Unit,
    onClickToFavorite: (ProductItem) ->Unit,
    onClickDeleteFavorite: (ProductItem) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(DIMENS_12dp),
        border = BorderStroke(width = 1.dp, color = GrayBorderStroke),
        elevation = DIMENS_6dp,
        modifier = modifier
            .width(DIMENS_144dp)
            .clickable {
                navController.navigate(Screen.Details.passProductId(productId = productItem.id))
            }
    ) {
        Column {

            Row {

                Image(
                    painter = painterResource(id = productItem.image),
                    contentDescription = stringResource(R.string.image_product),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(DIMENS_108dp)
                        .padding(DIMENS_12dp),
                    contentScale = ContentScale.FillBounds,

                )
                FavoriteButton(productItem=productItem,onClickToFavorite = onClickToFavorite, onClickDeleteFavorite = onClickDeleteFavorite)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(DIMENS_12dp)
            ) {




                Text(
                    text = productItem.title,
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    fontSize = TEXT_SIZE_16sp
                )

                Spacer(modifier = Modifier.height(DIMENS_6dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "₹${productItem.price}",
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = TEXT_SIZE_16sp
                    )

                    Button(
                        modifier = Modifier.size(DIMENS_24dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                        shape = RoundedCornerShape(DIMENS_6dp),
                        contentPadding = PaddingValues(DIMENS_4dp),
                        onClick = {
                            onClickToCart.invoke(productItem)
                        }
                    )
                    {
                        Icon(
                            modifier = Modifier.fillMaxSize(),
                            imageVector = Icons.Default.Add,
                            tint = Color.White,
                            contentDescription = stringResource(id = R.string.add)
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFFE91E1E),
    productItem: ProductItem,
    onClickToFavorite: (ProductItem) ->Unit,
    onClickDeleteFavorite: (ProductItem) ->Unit,
) {

    val isFavorite = remember {
        mutableStateOf(productItem.isFavorite)
    }

    IconToggleButton(
        checked = isFavorite.value,
        onCheckedChange = {
            isFavorite.value = !isFavorite.value
            if (isFavorite.value){
                onClickToFavorite.invoke(productItem)
            }else{
                onClickDeleteFavorite.invoke(productItem)
            }
        },
        modifier = Modifier.padding(0.dp)
    ) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 0.8f
                scaleY = 0.8f
            },
            imageVector = if (isFavorite.value) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = "Favorite Button"
        )
    }

}



@Preview
@Composable
fun ItemProductPreview() {
    ProductCard(
        productItem = ProductItem(
            id = 1,
            title = "Organic Bananas",
            description = "",
            image = R.drawable.product10,
            unit = "7pcs, Priceg",
            price = 4.99,
            nutritions = "100gr",
            review = 4.0
        ),
        navController = rememberNavController(),
        onClickToCart = {},
        onClickToFavorite = {},
        onClickDeleteFavorite = {}
    )
}