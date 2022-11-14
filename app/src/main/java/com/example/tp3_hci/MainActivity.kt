package com.example.tp3_hci

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tp3_hci.Screens.DetailsScreen
import com.example.tp3_hci.Screens.HomeScreen
import com.example.tp3_hci.Screens.MainScreen
import com.example.tp3_hci.components.MainAppBar
import com.example.tp3_hci.components.MainBottomBar
import com.example.tp3_hci.components.RoutineCard
import com.example.tp3_hci.navigation.MyAppNavHost
import com.example.tp3_hci.ui.theme.TP3HCITheme
import dev.leonardom.loginjetpackcompose.presentation.components.RoundedButton
import dev.leonardom.loginjetpackcompose.presentation.components.TransparentTextField

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP3HCITheme {
                val navController = rememberNavController()
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold (
                        topBar = {
                            MainAppBar(navController)
                        },
                        bottomBar = {
                            MainBottomBar(navController)
                        },
                    ) {
                        MyAppNavHost(navController)
                        //MainScreen()
                    }
                }
            }
        }
    }
}


