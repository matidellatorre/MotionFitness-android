package com.example.tp3_hci.components

import android.graphics.drawable.Drawable
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3_hci.R
import dev.leonardom.loginjetpackcompose.presentation.components.RoundedButton

@Composable
@Preview
fun RoutineCard(
    name: String,
    description: String,
){
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(7)

    ) {
        Column(
            modifier = Modifier.background(color = MaterialTheme.colors.surface)
        ) {
            Image(
                painter = painterResource(id = R.drawable.routine_placeholder),
                contentDescription = "Routine image",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                name,
                modifier = Modifier.padding(12.dp),
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
                    onClick = { TODO("Go to routine") },
                    modifier = Modifier
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                ){
                    Text(
                        text = "Start routine",
                        color = Color.White
                    )
                }
            }
        }
    }
}