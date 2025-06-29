package com.example.fefufirstproject.ui.widget

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

import com.example.fefufirstproject.R

import com.example.fefufirstproject.ui.theme.mainColor
import com.example.fefufirstproject.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = title, style = Typography.displayLarge)
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    tint = mainColor,
                    contentDescription = stringResource(id = R.string.back_icon_description)
                )
            }
        }
    )
}