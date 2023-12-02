package com.wilvelpinedanavarro.deliveryapp.signup.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class SignUpViewModel: ViewModel() {
    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _name = MutableLiveData<String>()
    val name : LiveData<String> = _name

    private val _surname = MutableLiveData<String>()
    val surname : LiveData<String> = _surname

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable : LiveData<Boolean> = _loginEnable

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onRegisterChanged(email: String, password: String, name: String, surname: String) {
        _email.value = email
        _password.value = password
        _name.value = name
        _surname.value = surname
        _loginEnable.value = (isValidEmail(email) && isValidPassword(password) && isValidName(name) && isValidSurname(surname))
    }

    private fun isValidName(name: String): Boolean = name.length > 6

    private fun isValidSurname(surname: String): Boolean = surname.length > 6

    private fun isValidPassword(password: String): Boolean = password.length > 6

    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    suspend fun onRegisterSelected(){
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false

    }
}