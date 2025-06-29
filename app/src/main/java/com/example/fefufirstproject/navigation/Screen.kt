package com.example.fefufirstproject.navigation

sealed class RootScreen(val route: String) {
    data object Auth : RootScreen("auth_screen")
}

sealed class Screen(val route: String) {
    data object Welcome : Screen("welcome")
    data object SignUp : Screen("signUp")
    data object SignIn : Screen("signIn")
}