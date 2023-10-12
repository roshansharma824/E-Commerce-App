package com.example.tummocandroidassignment.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tummocandroidassignment.R

val EComFontFamily = FontFamily(
    Font(R.font.ecom_black, FontWeight.Black),
    Font(R.font.ecom_extrabold, FontWeight.ExtraBold),
    Font(R.font.ecom_bold, FontWeight.Bold),
    Font(R.font.ecom_semibold, FontWeight.SemiBold),
    Font(R.font.ecom_medium, FontWeight.Medium),
    Font(R.font.ecom_regular, FontWeight.W400),
)

val TypographyStyle = Typography(
    h1 = TextStyle(
        fontFamily = EComFontFamily,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 49.sp
    ),
    body1 = TextStyle(
        fontFamily = EComFontFamily,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 24.sp
    ),
)