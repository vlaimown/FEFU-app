package com.example.fefufirstproject.presentation.ui.widget

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.fefufirstproject.R
import com.example.fefufirstproject.presentation.ui.theme.mainColor

@Composable
fun BaseButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClickListener: () -> Unit
) {
    Button(
        onClick = onClickListener,
        colors = ButtonDefaults.buttonColors(
            containerColor = mainColor,
            contentColor = Color.White
        ),
        enabled = enabled,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.button_corner_radius)),
        modifier = modifier
    ) {
        Text(text = text, style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold))
    }
}