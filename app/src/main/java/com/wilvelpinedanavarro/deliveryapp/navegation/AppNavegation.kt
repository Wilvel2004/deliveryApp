package com.wilvelpinedanavarro.deliveryapp.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wilvelpinedanavarro.deliveryapp.signin.ui.LoginScreen
import com.wilvelpinedanavarro.deliveryapp.signin.ui.SignInViewModel
import com.wilvelpinedanavarro.deliveryapp.signup.ui.RegisterScreen
import com.wilvelpinedanavarro.deliveryapp.signup.ui.SignUpViewModel
import com.wilvelpinedanavarro.deliveryapp.splash.SplashScreen

@Composable
fun AppNavegation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
            startDestination = AppScreens.SplashScreen.route){
        composable(AppScreens.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreens.LoginScreen.route){
            LoginScreen(navController,SignInViewModel())
        }
        composable(AppScreens.RegisterScreen.route){
            RegisterScreen(navController, SignUpViewModel())
        }
    }
}