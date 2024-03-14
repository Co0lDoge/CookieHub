package com.dogiumlabs.cookiehub.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dogiumlabs.cookiehub.data.getCookiesList
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme
import com.dogiumlabs.cookiehub.ui.utils.NavigationItem

enum class CookieApp(
    /***TODO @StringRes title***/
) {
    /** This class defines navigation routes.
     * For ui navigation items visit NavigationUtils **/
    HOME,
    LIST,
    DETAILS
}

@Composable
fun CookieApp(
    navController: NavHostController = rememberNavController()
) {
    val navigationItems = NavigationItem.navigationItems
    Scaffold(
        topBar = {
            CookieAppTopBar()
        },
        bottomBar = {
            CookieAppNavigationBar(navigationItems = navigationItems)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = CookieApp.LIST.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            composable(route = CookieApp.HOME.name) {
                HomeScreen()
            }
            composable(route = CookieApp.LIST.name) {
                ListScreen(cookiesList = getCookiesList())
            }
            composable(route = CookieApp.DETAILS.name) {
                DetailsScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookieAppTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Placeholder Title",
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}

@Composable
fun CookieAppNavigationBar(navigationItems: List<NavigationItem>) {
    /** Bar for low dp devices **/
    NavigationBar {
        navigationItems.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = { /*TODO*/ },
                label = { Text(navigationItem.title) }
            )
        }
    }
}

@Composable
fun CookieAppNavigationRail() {
    /** Bar for medium dp devices **/
    //TODO
}

@Composable
fun CookieAppNavigationDrawer() {
    /** Bar for high dp devices **/
    //TODO
}

@Composable
@Preview
fun CookieAppPreview() {
    CookieHubTheme {
        CookieApp()
    }
}