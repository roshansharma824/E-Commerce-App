package com.example.tummocandroidassignment.ui.presentation.common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import com.example.tummocandroidassignment.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.tummocandroidassignment.ui.domain.model.AboutItem
import com.example.tummocandroidassignment.ui.theme.Black
import com.example.tummocandroidassignment.ui.theme.DIMENS_16dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_1dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_20dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_32dp
import com.example.tummocandroidassignment.ui.theme.DIMENS_8dp
import com.example.tummocandroidassignment.ui.theme.GilroyFontFamily
import com.example.tummocandroidassignment.ui.theme.GrayBorderStroke
import com.example.tummocandroidassignment.ui.theme.TEXT_SIZE_16sp
import com.example.tummocandroidassignment.ui.utils.DataDummy

@Composable
fun ListContentAbout(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(top = DIMENS_32dp),
        verticalArrangement = Arrangement.spacedBy(DIMENS_8dp)
    ) {
        items(DataDummy.generateDummyAbout()) { items ->
            ItemAbout(aboutItem = items)
        }
    }

    Spacer(modifier = Modifier.height(DIMENS_8dp))

    Divider(modifier = Modifier.height(DIMENS_1dp), color = GrayBorderStroke)
}

@Composable
fun ItemAbout(
    modifier: Modifier = Modifier,
    aboutItem: AboutItem
) {
    Column {
        Divider(modifier = Modifier.height(DIMENS_1dp), color = GrayBorderStroke)

        Row(
            modifier = modifier
                .padding(start = DIMENS_16dp, end = DIMENS_16dp, top = DIMENS_20dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier.size(DIMENS_20dp),
                painter = painterResource(id = aboutItem.image),
                contentDescription = stringResource(R.string.image_category)
            )

            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = DIMENS_8dp)
                    .weight(1f),
                text = aboutItem.title,
                fontFamily = GilroyFontFamily,
                fontSize = TEXT_SIZE_16sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )

            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = Icons.Default.ArrowForward,
                contentDescription = stringResource(id = R.string.arrow_right)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListContentAboutPreview() {
    ListContentAbout()
}

@Preview(showBackground = true)
@Composable
fun ItemAboutPreview() {
    ItemAbout(
        aboutItem = AboutItem(
            image = R.drawable.ic_orders,
            title = "Orders"
        )
    )
}