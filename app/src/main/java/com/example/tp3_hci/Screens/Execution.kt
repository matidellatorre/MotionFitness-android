package com.example.tp3_hci.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.ui.theme.GreyGrey

@Composable
fun ExecutionScreen() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(12.dp)
            ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = Icons.Default.Cancel,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
            )
        }
        Text(
            text = "Calentamiento",
            fontSize = 32.sp,
            fontWeight = FontWeight(500)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp, vertical = 10.dp),
            thickness = 4.dp,
            color = GreyGrey
        )
        Text(
            text = "Burpees",
            color = MaterialTheme.colors.primary,
            fontSize = 28.sp,
            fontWeight = FontWeight(500)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Reps")
            Spacer(modifier = Modifier)
            Text(text = "8")
        }
    }
}