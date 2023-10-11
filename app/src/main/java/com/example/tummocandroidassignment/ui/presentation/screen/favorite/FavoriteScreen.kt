package com.example.tummocandroidassignment.ui.presentation.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tummocandroidassignment.R
import com.example.tummocandroidassignment.ui.presentation.common.card.FavoriteCard
import com.example.tummocandroidassignment.ui.presentation.component.SearchViewBar
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.DIMENS_10dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_18sp
import com.example.tummocandroidassignment.ui.utils.DataDummy

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = DIMENS_16dp),
                text = stringResource(R.string.find_products),
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = TEXT_SIZE_18sp,
                color = Black
            )

            SearchViewBar(hint = stringResource(id = R.string.search_category))

            LazyColumn(
                modifier = Modifier.padding(start = DIMENS_16dp, end = DIMENS_16dp),
//                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(DIMENS_10dp),
//                horizontalArrangement = Arrangement.spacedBy(DIMENS_12dp),
            ) {
                items(DataDummy.generateDummyProduct()) { productItem ->
                    FavoriteCard(productItem = productItem)
                }
            }
        }
    }
}

@Preview
@Composable
fun FavoriteScreenPreview() {
    FavoriteScreen()
}