package com.example.fullstacksocial.presentation.Register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.reflect.Constructor
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText : State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    private val _emailText = mutableStateOf("")
    val emailText : State<String> = _emailText

    private val _showPassword = mutableStateOf(false)
    val showPassword : State<Boolean> = _showPassword

    private val _isUsernameError = mutableStateOf("username is too short")
    val usernameError : State<String> = _isUsernameError

    private val _isPasswordError = mutableStateOf("")
    val passwordError : State<String> = _isPasswordError

    private val _isEmailError = mutableStateOf("")
    val emailError : State<String> = _isEmailError

    fun setUsernameText (username :String){
        _usernameText.value = username
    }

    fun setPasswordText (password : String){
        _passwordText.value = password
    }

    fun setEmailText (email : String){
        _emailText.value = email
    }

    fun setShowPassword(showPassword : Boolean) {
        _showPassword.value = showPassword
    }

    fun setIsEmailError (error : String){
        _isEmailError.value = error
    }

    fun setIsUsernameError(error : String) {
        _isUsernameError.value = error
    }

    fun setIsPasswordError(error : String) {
        _isPasswordError.value = error
    }
}