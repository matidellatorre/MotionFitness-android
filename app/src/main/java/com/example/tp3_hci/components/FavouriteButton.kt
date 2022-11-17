package com.example.tp3_hci.components

import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun FavoriteButton(
    routineId: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    isFavourite: Boolean,
    addFavourite: (Int) -> Unit,
) {

    var isFav by remember { mutableStateOf(isFavourite) }

    IconToggleButton(
        checked = isFav,
        onCheckedChange = {
            if(!isFav) {
                isFav = true
                addFavourite(routineId)
            }
        }
    ) {
        Icon(
            tint = color,

            imageVector = if (isFav) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = null
        )
    }

}