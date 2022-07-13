package com.example.navtest.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.navtest.R

val googleSans = FontFamily(
    Font(R.font.google_sans_regular),
    Font(R.font.google_sans_bold, FontWeight.Bold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = googleSans,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    body1 = TextStyle(
        fontFamily = googleSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)