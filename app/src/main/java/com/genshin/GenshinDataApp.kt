package com.genshin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.genshin.navigation.Screen
import com.genshin.ui.screen.detail.DetailScreen
import com.genshin.ui.screen.home.HomeScreen
import com.genshin.ui.screen.profile.ProfileScreen
import com.genshin.ui.theme.GenshinDataTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenshinDataApp(
    navController: NavHostController = rememberNavController(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column{
            TopAppBar(
                title = {
                    Text("Genshin Data")
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Profile.route)
                    }) {
                        Icon(
                            Icons.Filled.Person,
                            "about_page"
                        )
                    }
                })
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(
                        navigateToDetail = { name ->
                            navController.navigate(Screen.DetailCharacter.createRoute(name))
                        }
                    )
                }
                composable(Screen.Profile.route) {
                    ProfileScreen()
                }
                composable(
                    route = Screen.DetailCharacter.route,
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType }
                    )
                ) {
                    val name = it.arguments?.getString("name")?:""
                    DetailScreen(
                        name = name
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GenshinDataAppPreview() {
    GenshinDataTheme {
        GenshinDataApp()
    }
}
