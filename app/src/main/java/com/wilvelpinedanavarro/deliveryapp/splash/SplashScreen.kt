package com.wilvelpinedanavarro.deliveryapp.splash

import android.os.Build
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.wilvelpinedanavarro.deliveryapp.R
import com.wilvelpinedanavarro.deliveryapp.navegation.AppScreens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(5000)
        navController.popBackStack()
        navController.navigate(AppScreens.LoginScreen.route)
    }
    Splash()
}

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Splash(){
    val imageLoader = ImageLoader.Builder(LocalContext.current).components{
        if(Build.VERSION.SDK_INT >= 28){
            add(ImageDecoderDecoder.Factory())
        } else {
            add(GifDecoder.Factory())
        }
    }.build()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(painter = rememberAsyncImagePainter(R.drawable.animation_carga, imageLoader),
            contentDescription = "animation",
            Modifier.size(150.dp,150.dp),
        )
        Text(text = "Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight(200)
            )

    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    Splash()
}