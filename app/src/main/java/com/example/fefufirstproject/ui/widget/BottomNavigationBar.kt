package com.example.fefufirstproject.ui.widget

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.navigation.NavController
import com.example.fefufirstproject.presentation.navigation.BottomNavigationRoot

import com.example.fefufirstproject.ui.theme.Typography
import com.example.fefufirstproject.ui.theme.mainColor
import com.example.fefufirstproject.ui.theme.hintColor
import com.example.fefufirstproject.ui.theme.boldTextColor
import com.example.fefufirstproject.ui.theme.nullColor

import androidx.compose.runtime.setValue

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String) {
    val items = listOf(
        BottomNavigationRoot.Activity,
        BottomNavigationRoot.User
    )
    var selectedItem by remember { mutableStateOf(BottomNavigationRoot.Activity.route) }

    NavigationBar(
        containerColor = Color.Transparent
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.iconUnselectedId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        stringResource(id = screen.labelResId),
                        style = if (selectedItem == screen.route) {
                            Typography.titleSmall
                        } else {
                            Typography.bodySmall
                        }
                    )
                },
                selected = selectedItem == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                    navController.popBackStack(currentRoute, inclusive = true)
                    selectedItem = screen.route
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = nullColor,
                    selectedTextColor = boldTextColor,
                    unselectedTextColor = hintColor,
                    selectedIconColor = mainColor
                )
            )
        }
    }
}