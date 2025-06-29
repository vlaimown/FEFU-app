package com.example.fefufirstproject.presentation.features.user

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.fefufirstproject.presentation.navigation.UserScreen
import com.example.fefufirstproject.presentation.navigation.BottomNavigationRoot
import com.example.fefufirstproject.presentation.navigation.MainScreen

fun NavGraphBuilder.addUserRoot(navController: NavController) {
    navigation(
        route = BottomNavigationRoot.User.route,
        startDestination = MainScreen.UserScreen.route
    ) {
        addUserScreen(navController)
    }
}

fun NavGraphBuilder.addUserScreen(navController: NavController) {
    composable(MainScreen.UserScreen.route) {
        UserScreen()
    }
}

fun NavGraphBuilder.addProfileScreen() {
    composable(UserScreen.ProfileScreen.route) {
        ProfileScreen()
    }
}
