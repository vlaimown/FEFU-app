package com.example.fefufirstproject.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

import com.example.fefufirstproject.presentation.features.sign_in.SignIn
import com.example.fefufirstproject.presentation.features.signup.SignUp
import com.example.fefufirstproject.presentation.features.welcome.Welcome

@Composable
fun AppNavigation(innerPaddingValues: PaddingValues) {
    val navController = rememberNavController()
    val isLoggedIn = false

    NavHost(
        navController = navController,
        startDestination = if (!isLoggedIn) RootScreen.Auth.route else RootScreen.Auth.route,
        modifier = Modifier.padding(innerPaddingValues)
    ) {
        addAuth(navController)
    }
}

private fun NavGraphBuilder.addAuth(navController: NavController) {
    navigation(
        route = RootScreen.Auth.route,
        startDestination = Screen.Welcome.route
    ) {
        addWelcome(navController)
        addSignUp(navController)
        addSignIn(navController)
    }
}

private fun NavGraphBuilder.addWelcome(navController: NavController) {
    composable(Screen.Welcome.route) {
        Welcome(navController = navController)
    }
}

private fun NavGraphBuilder.addSignUp(navController: NavController) {
    composable(Screen.SignUp.route) {
        SignUp(navController = navController)
    }
}

private fun NavGraphBuilder.addSignIn(navController: NavController) {
    composable(Screen.SignIn.route) {
        SignIn(navController = navController)
    }
}