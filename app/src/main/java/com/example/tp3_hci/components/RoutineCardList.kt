package com.example.tp3_hci.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp3_hci.data.model.Routine

@Composable
fun RoutineCardList(
    list: List<Routine>,
    favouriteList: List<Int>? = null,
    hasFavourites: Boolean,
    addFavourite: ((Int) -> Unit)? = null,
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .padding(horizontal = 15.dp),
    ) {
        items(
            count = list?.size?:0,
            key = { index ->
                list?.get(index)?.id.toString()
            }
        ) { index ->
            RoutineCard(
                name = list?.get(index)?.name ?: "Error",
                description = list?.get(index)?.detail ?: "",
                id = list?.get(index)?.id!!,
                isFavourite = favouriteList.orEmpty().contains(list?.get(index)?.id!!),
                hasFavourites = hasFavourites,
                addFavourite = addFavourite?:null,
                onNavigateToRoutineDetails = onNavigateToRoutineDetails,
                onNavigateToExecution = onNavigateToExecution
            )
        }
    }
}