package com.wilvelpinedanavarro.deliveryapp.signin.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.wilvelpinedanavarro.deliveryapp.R
import com.wilvelpinedanavarro.deliveryapp.navegation.AppScreens
import com.wilvelpinedanavarro.deliveryapp.signin.ui.composables.RoundedButton
import com.wilvelpinedanavarro.deliveryapp.signin.ui.composables.TextFieldEmail
import com.wilvelpinedanavarro.deliveryapp.signin.ui.composables.TextFieldPassword
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController,viewModel: SignInViewModel){
    Box(
        Modifier
            .fillMaxSize()
            .padding(14.dp)){
        Login(Modifier.align(Alignment.Center),viewModel,navController)
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: SignInViewModel, navController: NavController){
    val email :String by viewModel.email.observeAsState(initial = "")
    val password :String by viewModel.password.observeAsState(initial = "")
    val loginEnable:Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading:Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()
    
    if(isLoading){
        Box(Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(
            modifier = modifier
        ) {
            HeaderImage(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp)
            )
            EmailField(email) { viewModel.onLoginChanged(it, password) }
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordField(password) { viewModel.onLoginChanged(email, it) }
            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(
                Modifier
                    .align(Alignment.End)
                    .clickable { navController.navigate(AppScreens.RegisterScreen.route) }
            )
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(loginEnable) {
                coroutineScope.launch {
                    viewModel.onLoginSelected()
                }
            }
        }
    }
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    RoundedButton(text = "Log In", onClick = { onLoginSelected() }, enabled = loginEnable)
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "You don't have an account? Sign Up",
        modifier = modifier,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(31,38,54)
    )
}

@Composable
fun PasswordField(password: String, onTextFieldChanged:(String)->Unit){
    TextFieldEmail(
        value =  password,
        placeholder = "Password",
        onTextChanged = onTextFieldChanged
        )
}

@Composable
fun EmailField(email: String, onTextFieldChanged:(String)->Unit){
    TextFieldPassword(
        value =  email,
        placeholder = "Email",
        onTextChanged = onTextFieldChanged
    )
}

@Composable
fun HeaderImage(modifier: Modifier){
    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription = "Header",
        modifier = modifier,
    )
}


