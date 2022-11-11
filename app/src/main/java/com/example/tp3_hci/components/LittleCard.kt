package com.example.tp3_hci.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R

@Composable
fun LittleCard(
    name: String,
    id: Int,
    //description: String,
    onNavigateToRoutineDetails: (id:Int) -> Unit
){
    Card(
        modifier = Modifier
            .width(175.dp)
            .height(125.dp)
            .clickable { onNavigateToRoutineDetails(id) },
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.routine_placeholder),
            contentDescription = "Routine image",
            modifier = Modifier
                .fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )
        Column (
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                name,
                modifier = Modifier
                    .padding(12.dp),
                style = MaterialTheme.typography.h6.copy(
                    color = Color.White,
                    fontWeight = FontWeight(500),
                ),
            )
        }
    }
}