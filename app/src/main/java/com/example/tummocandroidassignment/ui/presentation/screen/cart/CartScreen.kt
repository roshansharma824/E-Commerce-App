package com.example.tummocandroidassignment.ui.presentation.screen.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tummocandroidassignment.ui.presentation.common.content.ListContentCart
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.Green
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_18sp

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    val productCartList by cartViewModel.productCartList.collectAsState()

    Scaffold(
        topBar = {
            // inside top bar we are specifying background color.
            TopAppBar(backgroundColor = Green,
                // along with that we are specifying title for our top bar.
                title = {
                    // in the top bar we are specifying tile as a text
                    Text(
                        // on below line we are specifying
                        // text to display in top app bar.
                        text = "My Cart",

                        // on below line we are specifying
                        // modifier to fill max width.
                        modifier = Modifier.fillMaxWidth(),

                        // on below line we are
                        // specifying text alignment.
                        textAlign = TextAlign.Center,

                        // on below line we are
                        // specifying color for our text.
                        color = Color.White
                    )
                }
            )
        } ,
    ) { padding ->
        Column(
            modifier = modifier.fillMaxSize()

                .padding(padding)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = DIMENS_16dp),
                text = stringResource(R.string.my_cart),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = TEXT_SIZE_18sp,
                color = Black
            )

            Spacer(modifier = Modifier.height(DIMENS_16dp))

            ListContentCart(
                cartProducts = productCartList,
                onClickDeleteCart = { productItem ->
                    val quantity = productItem.quantity

                    if (quantity>1){
                        cartViewModel.addCart(productItem.copy(quantity = quantity-1 ))
                    }else{
                        cartViewModel.deleteCart(productItem.copy(isCart = false))
                    }



                },
                onClickToCart = { productItem ->
                    val quantity = productItem.quantity
                    cartViewModel.addCart(productItem.copy(quantity = quantity+1 ))
                }
            )
        }
    }


}