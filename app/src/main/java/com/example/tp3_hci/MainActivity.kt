package com.example.tp3_hci

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.tp3_hci.R
import com.example.tp3_hci.components.MainBottomBar
import com.example.tp3_hci.data.model.Sport
import com.example.tp3_hci.navigation.MyAppNavHost
import com.example.tp3_hci.ui.appBar.MainAppBar
import com.example.tp3_hci.ui.main.MainViewModel
import com.example.tp3_hci.ui.model.OrderBy
import com.example.tp3_hci.ui.routines.RoutinesUiState
import com.example.tp3_hci.ui.theme.TP3HCITheme
import com.example.tp3_hci.util.getViewModelFactory
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMotionApp()
        }
    }

    @Composable
    private fun MyMotionApp() {
        TP3HCITheme {
            val navController = rememberNavController()
            var orderBy by remember { mutableStateOf("date") }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Scaffold (
                    topBar = {
                        MainAppBar(
                            navController = navController,
                            onNavigateToLogin =  { navController.navigate("login") },
                            onOrderBy = { selection: String -> orderBy = selection },
                        )
                    },
                    bottomBar = {
                        MainBottomBar(navController)
                    },
                    content = { paddingValues ->
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = paddingValues.calculateBottomPadding()
                            )) {
                            MyAppNavHost(navController, orderBy)
                        }
                    }
                )
            }
        }
    }
}