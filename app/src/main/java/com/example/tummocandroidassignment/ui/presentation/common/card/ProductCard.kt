package com.example.tummocandroidassignment.ui.presentation.common.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.tummocandroidassignment.ui.theme.DIMENS_10dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_12dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_14dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_174dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_20dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_24dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_46dp
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
    onClickToCart: (ProductItem) -> Unit
) {
    Card(
        shape = RoundedCornerShape(DIMENS_12dp),
        border = BorderStroke(width = 1.dp, color = GrayBorderStroke),
        modifier = modifier
            .padding(DIMENS_12dp)
            .width(DIMENS_174dp)
            .clickable {
                navController.navigate(Screen.Details.passProductId(productId = productItem.id))
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(DIMENS_12dp)
        ) {
            Image(
                painter = painterResource(id = productItem.image),
                contentDescription = stringResource(R.string.image_product),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(DIMENS_80dp)
            )

            Spacer(modifier = Modifier.height(DIMENS_24dp))

            Text(
                text = productItem.title,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                color = Black,
                fontSize = TEXT_SIZE_16sp
            )

            Spacer(modifier = Modifier.height(DIMENS_6dp))

            Text(
                text = productItem.unit,
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Medium,
                color = GraySecondTextColor,
                fontSize = TEXT_SIZE_12sp
            )

            Spacer(modifier = Modifier.height(DIMENS_20dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "$${productItem.price}",
                    fontFamily = GilroyFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    fontSize = TEXT_SIZE_18sp
                )

                Button(
                    modifier = Modifier.size(DIMENS_46dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Green),
                    shape = RoundedCornerShape(DIMENS_14dp),
                    contentPadding = PaddingValues(DIMENS_10dp),
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
        onClickToCart = {}
    )
}