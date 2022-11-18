package com.example.tp3_hci.ui.rate

import android.util.Log
import android.widget.RatingBar
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
import com.example.tp3_hci.ui.main.MainViewModel
import com.example.tp3_hci.util.getViewModelFactory
import com.example.tp3_hci.ui.routines.RoutinesViewModel
import com.example.tp3_hci.ui.routines.canGetAllRoutines
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import kotlinx.coroutines.launch

fun RoutinesScreen(
) {

}

@Composable
fun RateScreen(
    routineId: String
) {
    val zero = 0
    var rating by remember { mutableStateOf(zero.toFloat()) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.rate),
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        )
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("This rating will be public", modifier = Modifier.padding(vertical = 40.dp))
                RatingBar(
                    value = rating,
                    config = RatingBarConfig()
                        .style(RatingBarStyle.HighLighted),
                    onValueChange = {
                        rating = it
                    },
                    onRatingChanged = {
                        Log.d("TAG", "onRatingChanged: $it")
                    }
                )
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .padding(vertical = 40.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                shape = RoundedCornerShape(35.dp)
            ) {
                Text(
                    text = "Submit",
                    color = Color.White
                )
            }
        }
    }




}