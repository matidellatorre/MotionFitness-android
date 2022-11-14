package com.example.tp3_hci.Screens
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3_hci.util.getViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tp3_hci.data.model.Sport
import com.example.tp3_hci.main.*
import kotlin.random.Random

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(factory = getViewModelFactory())
) {
    val uiState = viewModel.uiState

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (!uiState.isAuthenticated) {
            Button(
                onClick = {
                    viewModel.login("johndoe", "1234567890")
                }){
                Text(text = "Login")
            }
        } else {
            Button(
                onClick = {
                    viewModel.logout()
                }){
                Text(text = "Logout")
            }
        }

        Button(
            enabled = uiState.canGetCurrentUser,
            onClick = {
                viewModel.getCurrentUser()
            }) {
            Text(text = "Get current user")
        }
        Button(
            enabled = uiState.canGetAllSports,
            onClick = {
                viewModel.getSports()
            }){
            Text(text = "Get all sports")
        }
        Button(
            enabled = uiState.canGetCurrentSport,
            onClick = {
                val currentSport = uiState.currentSport!!
                viewModel.getSport(currentSport.id!!)
            }){
            Text(text = "Get current sport")
        }
        Button(
            enabled = uiState.canAddSport,
            onClick = {
                val random = Random.nextInt(0, 100)
                val sport = Sport(name = "Sport $random", detail = "Detail $random")
                viewModel.addOrModifySport(sport)
            }){
            Text(text = "Add random sport")
        }
        Button(
            enabled = uiState.canModifySport,
            onClick = {
                val random = Random.nextInt(0, 100)
                val currentSport = uiState.currentSport!!
                val sport = Sport(currentSport.id, currentSport.name, detail = "Detail $random")
                viewModel.addOrModifySport(sport)
            }){
            Text(text = "Modify sport")
        }
        Button(
            enabled = uiState.canDeleteSport,
            onClick = {
                val currentSport = uiState.currentSport!!
                viewModel.deleteSport(currentSport.id!!)
            }){
            Text(text = "Delete sport")
        }
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            val currentUserData = uiState.currentUser?.let {
                "Current User: ${it.firstName} ${it.lastName} (${it.email})"
            }
            Text(
                text = currentUserData?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                fontSize = 18.sp
            )
            val currentSportData = uiState.currentSport?.let {
                "Current Sport: (${it.id}) ${it.name} - ${it.detail}"
            }
            Text(
                text = currentSportData?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                fontSize = 18.sp
            )
            Text(
                text = "Total Sports: ${uiState.sports?.size?: "unknown"}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                fontSize = 18.sp
            )
            Text(
                text = uiState.message?: "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                fontSize = 18.sp
            )
        }
    }
}