package com.example.navtest.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.navtest.configs.MangoList


@Composable
fun DetailScreen(mangoIndex: Int?) {

    val mList = MangoList()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(mList.mangoes[mangoIndex ?: 0].name) },
                backgroundColor = MaterialTheme.colors.background
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            AsyncImage(
                model = mList.mangoes[mangoIndex ?: 0].imageUrl,
                contentDescription = null,
                modifier = Modifier.height(150.dp).width(150.dp),
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier.fillMaxSize()
                    .padding(top = 15.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
            ) {
                Column(
                    modifier = Modifier.padding(25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {

                        Icon(
                            imageVector = Icons.Rounded.Place, contentDescription = "Map Pin",
                            tint = Color.Red
                        )
                        Spacer(
                            modifier = Modifier.width(15.dp)
                        )

                        Text(
                            mList.mangoes[mangoIndex ?: 0].location
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            mList.mangoes[mangoIndex ?: 0].details,
                            fontSize = 21.sp,
                            style = MaterialTheme.typography.body1,
                        )
                    }
                }
            }
        }
    }
}