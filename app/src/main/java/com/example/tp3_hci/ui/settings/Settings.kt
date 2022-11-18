package com.example.tp3_hci.ui.settings

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.R
import kotlinx.coroutines.launch


@Composable
fun SettingsScreen() {

    var var1 by remember { mutableStateOf(false) }
    var var2 by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        Text(
            text = "App features",
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 20.dp),
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight(500)
            )
        )
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            elevation = 5.dp,
            backgroundColor = MaterialTheme.colors.background,
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(stringResource(id = R.string.settings_enable_suggestions), Modifier.padding(start = 5.dp))
                Switch(checked = var1, onCheckedChange = { value -> var1 = value}, colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.primary,
                    uncheckedThumbColor = Color.LightGray,
                    checkedTrackColor = MaterialTheme.colors.primary,
                    uncheckedTrackColor = Color.LightGray,
                ))
            }
        }
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            elevation = 5.dp,
            backgroundColor = MaterialTheme.colors.background
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text("Feature 2")
                Switch(checked = var2, onCheckedChange = { value -> var2 = value},
                    colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.primary,
                    uncheckedThumbColor = Color.LightGray,
                    checkedTrackColor = MaterialTheme.colors.primary,
                    uncheckedTrackColor = Color.LightGray)
                )
            }
        }

    }
}

