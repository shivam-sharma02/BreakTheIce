package com.example.fullstacksocial.presentation.utils

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")

    object MainFeedScreen : Screen("main_feed_screen")
}