package com.example.echo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import com.example.echo.ui.theme.EchoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EchoTheme {
                Scaffold(
                    bottomBar = {
                        NavigationBarScaffold()
                    }
                ){ innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

enum class Destination(
    val route: String,
    val label: String,
    val iconId: Int,
    val contentDescription: String
){
    MAIN_MENU("main_menu","Main",R.drawable.star, "Main_Menu"),
    MODES("modes","Modes",R.drawable.account, "Modes"),
    HELP("help","Help",R.drawable.help,"Help")
}

@Composable
fun Sliders(){
    //There is a vertical slider directly from material design

}

@Composable
fun Charge(){

}

@Composable
fun FavOptions(){

}

@Composable
fun NavigationBarScaffold(){
    val startDestination = Destination.MAIN_MENU
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    NavigationBar(windowInsets = NavigationBarDefaults.windowInsets){
        Destination.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedDestination == index,
                onClick = {
                    selectedDestination = index
                },
                icon = {
                    Icon(
                        painter = painterResource(destination.iconId),
                        contentDescription = destination.contentDescription
                    )
                },
                label = {
                    Text(destination.label)
                }
            )
        }

    }

}

@Composable
fun MainScreen(modifier: Modifier = Modifier){
    Sliders()
    Charge()
    FavOptions()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EchoTheme {
        MainScreen()
    }
}