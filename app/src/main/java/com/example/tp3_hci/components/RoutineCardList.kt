package com.example.tp3_hci.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HideSource
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.tp3_hci.R
import com.example.tp3_hci.data.model.Review
import com.example.tp3_hci.data.model.Routine

@Composable
fun RoutineCardList(
    list: List<Routine>,
    hasReviews: Boolean,
    reviews: HashMap<Int, List<Review>>? = null,
    favouriteList: List<Int>? = null,
    hasFavourites: Boolean,
    addFavourite: ((Int) -> Unit)? = null,
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
) {

    var imgIds by remember { mutableStateOf(listOf(R.drawable.routine1, R.drawable.routine2, R.drawable.routine3, R.drawable.routine4, R.drawable.routine5, R.drawable.routine6, R.drawable.routine7, R.drawable.routine8 )) }

    if (list==null || list.isEmpty()){
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
                ){
            EmptyState(text = stringResource(id = R.string.empty_routines), imgVector = Icons.Default.HideSource)
        }
    } else {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            columns = GridCells.Adaptive(300.dp)
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
                    imgId = imgIds[index%8],
                    isFavourite = favouriteList.orEmpty().contains(list?.get(index)?.id!!),
                    hasFavourites = hasFavourites,
                    addFavourite = addFavourite?:null,
                    hasReview = hasReviews,
                    review = reviews.orEmpty().get(list.get(index).id).orEmpty().map { review -> review.score!! }.average().toInt(),
                    onNavigateToRoutineDetails = onNavigateToRoutineDetails,
                    onNavigateToExecution = onNavigateToExecution
                )
            }
        }
    }

}