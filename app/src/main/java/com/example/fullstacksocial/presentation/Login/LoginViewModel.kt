package com.example.fullstacksocial.presentation.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.reflect.Constructor
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText : State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword : State<Boolean> = _showPassword

    private val _isUsernameError = mutableStateOf("username is too short")
    val usernameError : State<String> = _isUsernameError

    private val _isPasswordError = mutableStateOf("")
    val passwordError : State<String> = _isPasswordError

    fun setUsernameText (username :String){
        _usernameText.value = username
    }

    fun setPasswordText (password : String){
        _passwordText.value = password
    }

    fun setShowPassword(showPassword : Boolean) {
        _showPassword.value = showPassword
    }

    fun setIsUsernameError(error : String) {
        _isUsernameError.value = error
    }

    fun setIsPasswordError(error : String) {
        _isPasswordError.value = error
    }
}