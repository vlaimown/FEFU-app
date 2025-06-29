package com.example.fefufirstproject.ui.widget

import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource

import com.example.fefufirstproject.R
import com.example.fefufirstproject.ui.theme.backgroundSecondary
import com.example.fefufirstproject.ui.theme.Typography

@Composable
fun CommentBox(comment: String) {
    Box(
        modifier = Modifier.fillMaxWidth().padding(dimensionResource(id = R.dimen.padding_xxsmall))
            .background(backgroundSecondary).padding(dimensionResource(id = R.dimen.padding_small))
    ) {
        Text(text = comment, style = Typography.bodyMedium)
    }
}
