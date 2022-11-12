package com.example.tp3_hci.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.components.Timer
import com.example.tp3_hci.ui.theme.Grey2
import com.example.tp3_hci.ui.theme.GreyGrey

@Composable
fun ExecutionScreen() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp)
                    .padding(top = 3.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.Cancel,
                    contentDescription = null,
                    modifier = Modifier
                        .size(35.dp),
                    tint = Grey2
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
        }
        Box (
            contentAlignment = Alignment.Center,
                ) {
            Timer(
                totalTime = 10L * 1000L,
                handleColor = MaterialTheme.colors.primary,
                inactiveBarColor = GreyGrey,
                activeBarColor = MaterialTheme.colors.primary,
                modifier = Modifier
                    .size(280.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(bottom = 80.dp)
        ) {
            Row (
                    ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text="boton1")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text="boton2")
                }
            }
        }
    }
}