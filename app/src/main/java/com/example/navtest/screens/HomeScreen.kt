package com.example.navtest.screens

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.navtest.R
import com.example.navtest.Screen
import com.example.navtest.configs.MangoList


@Composable
fun HomeScreen(navController: NavController) {

    val mList = MangoList()

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val context = LocalContext.current

    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Image(
                            painter = rememberAsyncImagePainter(
                                ImageRequest.Builder(context).data(data = R.drawable.mango).build(),
                                imageLoader = imageLoader
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(30.dp).width(30.dp),
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text("Mango Mania")
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = rememberAsyncImagePainter(
                                ImageRequest.Builder(context).data(data = R.drawable.mango).build(),
                                imageLoader = imageLoader
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.height(30.dp).width(30.dp),
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.background
            )
        },
    ) {
        LazyColumn {
            items(mList.mangoes.size) { index ->
                Card(
                    modifier = Modifier.fillMaxSize()
                        .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                        .clickable {
                            navController.navigate(Screen.DetailScreen.route + "/$index")
                        },
                    elevation = 4.dp,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(25.dp)) {
                        Text(mList.mangoes[index].name, style = MaterialTheme.typography.h1)
                        Spacer(
                            modifier = Modifier.height(15.dp)
                        )
                        Row {
                            Box(
                                modifier = Modifier.width((screenWidth * 3 / 5).dp)
                            ) {
                                Text(
                                    mList.mangoes[index].details,
                                    style = MaterialTheme.typography.body1,
                                    maxLines = 5,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }
                            Spacer(
                                modifier = Modifier.width(10.dp)
                            )
                            Box(
                                modifier = Modifier.width((screenWidth * 2 / 5 - 10).dp)
                            ) {
                                AsyncImage(
                                    model = mList.mangoes[index].imageUrl,
                                    contentDescription = null,
                                    modifier = Modifier.height(80.dp).width(80.dp)
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier.height(25.dp)
                        )
                        Row {

                            Icon(
                                imageVector = Icons.Rounded.Place, contentDescription = "Map Pin",
                                tint = Color.Red
                            )
                            Spacer(
                                modifier = Modifier.width(15.dp)
                            )
                            Box(
                                modifier = Modifier.width((screenWidth * 3.8 / 5).dp)
                            ) {
                                Text(
                                    mList.mangoes[index].location
                                )
                            }
                        }

                    }
                }
            }

        }
    }
}