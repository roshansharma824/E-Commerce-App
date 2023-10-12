package com.example.tummocandroidassignment.ui.presentation.screen.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tummocandroidassignment.ui.presentation.common.content.ListContentCart
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.Green

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    val productCartList by cartViewModel.productCartList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                contentColor = Color.Transparent,
                elevation = 0.dp,
                title = {
                    Text(
                        text = stringResource(id = R.string.my_cart),
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
        Column(
            modifier = modifier.fillMaxSize()

                .padding(padding)
        ) {


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