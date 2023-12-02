package com.wilvelpinedanavarro.deliveryapp.signup.ui

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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
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
import com.wilvelpinedanavarro.deliveryapp.signup.ui.composable.RoundedButton
import com.wilvelpinedanavarro.deliveryapp.signup.ui.composable.TextFieldPassword
import com.wilvelpinedanavarro.deliveryapp.signup.ui.composable.TextFieldEmail
import com.wilvelpinedanavarro.deliveryapp.signup.ui.composable.TextFieldName
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavController, viewModel: SignUpViewModel){
    Box(
        Modifier
            .fillMaxSize()
            .padding(14.dp)){
        Register(Modifier.align(Alignment.Center),viewModel,navController)
    }
}

@Composable
fun Register(modifier: Modifier, viewModel: SignUpViewModel, navController: NavController){
    val email :String by viewModel.email.observeAsState(initial = "")
    val password :String by viewModel.password.observeAsState(initial = "")
    val name :String by viewModel.name.observeAsState(initial = "")
    val surname :String by viewModel.surname.observeAsState(initial = "")
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
            NameField(name) {viewModel.onRegisterChanged(email, password, it, surname)}
            Spacer(modifier = Modifier.padding(8.dp))
            SurnameField(surname) {viewModel.onRegisterChanged(email, password, name, it)}
            Spacer(modifier = Modifier.padding(8.dp))
            EmailField(email) { viewModel.onRegisterChanged(it, password, name, surname) }
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordField(password) { viewModel.onRegisterChanged(email, it, name, surname) }
            Spacer(modifier = Modifier.padding(8.dp))
            HaveAccount(
                Modifier
                    .align(Alignment.End)
                    .clickable {navController.navigate(AppScreens.LoginScreen.route)}
            )
            Spacer(modifier = Modifier.padding(16.dp))
            RegisterButton(loginEnable) {
                coroutineScope.launch {
                    viewModel.onRegisterSelected()
                }
            }
        }
    }
}

@Composable
fun RegisterButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    RoundedButton(text = "Register", onClick = { onLoginSelected() }, enabled = loginEnable)
}

@Composable
fun HaveAccount(modifier: Modifier) {
    Text(
        text = "Do you have an account? Sign In",
        modifier = modifier,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(31,38,54)
    )
}

@Composable
fun NameField(name: String, onTextFieldChanged:(String)->Unit){
    TextFieldName(value = name, onTextChanged = onTextFieldChanged, placeholder = "Name")
}

@Composable
fun SurnameField(surname: String, onTextFieldChanged:(String)->Unit){
    TextFieldName(value = surname, onTextChanged = onTextFieldChanged, placeholder = "Surname")
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