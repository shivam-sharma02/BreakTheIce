package com.example.fullstacksocial.utils

sealed class Screen(route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
}