package com.example.fefufirstproject.presentation.features.welcome.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.fefufirstproject.presentation.features.welcome.WelcomeScreen
import com.example.fefufirstproject.presentation.navigation.AuthScreen

fun NavGraphBuilder.addWelcome(navController: NavController) {
    composable(AuthScreen.Welcome.route) {
        WelcomeScreen(
            onNavigateToSignIn = { navController.navigate(AuthScreen.SignIn.route) },
            onNavigateToSignUp = { navController.navigate(AuthScreen.SignUp.route) }
        )
    }
}