package com.example.tummocandroidassignment.ui.presentation.common.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import com.example.tummocandroidassignment.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tummocandroidassignment.ui.domain.model.ProductItem
import com.example.tummocandroidassignment.ui.navigation.screen.Screen
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.*
import com.example.tummocandroidassignment.ui.theme.DIMENS_1dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_20dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_6dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.GrayBorderStroke
import com.example.tummocandroidassignment.ui.theme.GraySecondTextColor
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_16sp

@Composable
fun FavoriteCard(
    modifier: Modifier = Modifier,
    productItem: ProductItem,
    onClickDeleteFavorite: (ProductItem) -> Unit
) {

    Card(
        shape = RoundedCornerShape(DIMENS_12dp),
        border = BorderStroke(width = 1.dp, color = GrayBorderStroke),
        elevation = DIMENS_6dp,
        modifier = modifier
            .clickable {
//                navController.navigate(Screen.Details.passProductId(productId = productItem.id))
            }
    ){
        Column(
            modifier = modifier
                .background(Color.White)
                .padding(DIMENS_16dp)
                .fillMaxWidth()
                .height(DIMENS_68dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = productItem.image),
                    contentDescription = stringResource(id = R.string.image_product),
                    contentScale = ContentScale.Inside,
                )

                Spacer(modifier = Modifier.padding(start = DIMENS_16dp))

                Column(
                    modifier = Modifier
                        .weight(1F)
                        .padding(start = DIMENS_16dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = productItem.title,
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        fontSize = TEXT_SIZE_16sp,
                    )

                    Spacer(modifier = Modifier.height(DIMENS_6dp))

                    Text(
                        text = "${productItem.price}",
                        fontFamily = GilroyFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        fontSize = TEXT_SIZE_16sp,
//                    modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    FavoriteButton(productItem = productItem, onClickDeleteFavorite = onClickDeleteFavorite, onClickToFavorite = onClickDeleteFavorite)
                    Button(
                        modifier = Modifier.size(DIMENS_24dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                        shape = RoundedCornerShape(DIMENS_6dp),
                        contentPadding = PaddingValues(DIMENS_4dp),
                        onClick = {
//                            onClickDeleteFavorite.invoke(productItem)
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

            Spacer(modifier = Modifier.height(DIMENS_20dp))

            Divider(modifier = Modifier.height(DIMENS_1dp), color = GrayBorderStroke)
        }
    }

}

@Preview
@Composable
fun FavoriteCardPreview() {
    FavoriteCard(
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
        onClickDeleteFavorite = {}
    )
}