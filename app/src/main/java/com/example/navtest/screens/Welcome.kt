package com.example.navtest.screens

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.navtest.R
import com.example.navtest.Screen

@Composable
fun WelcomeScreen(navController: NavController) {

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

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Mango Mania",
                style = MaterialTheme.typography.h1,
                fontSize = 40.sp,
            )
            Spacer(
                modifier = Modifier.height(50.dp)
            )
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(context).data(data = R.drawable.mango).build(),
                    imageLoader = imageLoader
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(300.dp).width(300.dp),
            )
            Spacer(
                modifier = Modifier.height(50.dp)
            )
            Card (
                shape = RoundedCornerShape(60.dp),
                backgroundColor = Color.White
            ){
                IconButton(
                    onClick = {
                        navController.navigate(Screen.HomeScreen.route){
                            popUpTo(
                                Screen.WelcomeScreen.route,
                            ){
                                inclusive = true
                            }
                        }
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Rounded.PlayArrow,
                            contentDescription = "Play",
                            tint = Color.Black,
                            modifier = Modifier.height(60.dp).width(60.dp)
                        )
                    }
                )
            }
        }
    }


}