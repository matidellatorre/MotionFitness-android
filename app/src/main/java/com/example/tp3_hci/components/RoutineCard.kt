package com.example.tp3_hci.components

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grade
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3_hci.R
import dev.leonardom.loginjetpackcompose.presentation.components.RoundedButton

@Composable
fun RoutineCard(
    name: String,
    description: String,
    id: Int,
    hasFavourites: Boolean,
    onNavigateToRoutineDetails: (id:Int) -> Unit,
    onNavigateToExecution: (id:Int) -> Unit,
) {
    Card(
        modifier = Modifier.clickable { onNavigateToRoutineDetails(id) },
        shape = RoundedCornerShape(7),
    ) {
        Column(
            modifier = Modifier.background(color = MaterialTheme.colors.surface)
        ) {
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.routine_placeholder),
                    contentDescription = "Routine image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.FillWidth
                )
                if(hasFavourites)
                    FavoriteButton(routineId = id, modifier = Modifier.padding(12.dp))
            }
            Text(
                name,
                modifier = Modifier.padding(start = 12.dp, top = 12.dp),
                style = MaterialTheme.typography.h5
            )
            Text(
                description,
                modifier = Modifier.padding(horizontal = 12.dp),
                style = MaterialTheme.typography.body1
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End,
            ) {
                Button(
                    onClick = { onNavigateToExecution(id) },
                    modifier = Modifier
                        .padding(end = 15.dp, bottom = 5.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    shape = RoundedCornerShape(35.dp)
                ) {
                    Text(
                        text = stringResource(R.string.start_routine),
                        color = Color.White
                    )
                }
            }
        }
    }
}
