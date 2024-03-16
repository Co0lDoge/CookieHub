package com.dogiumlabs.cookiehub.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dogiumlabs.cookiehub.data.getCookiesList
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme
import com.dogiumlabs.cookiehub.ui.utils.CookieNavItem


@Composable
fun CookieApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            CookieAppTopBar()
        },
        bottomBar = {
            CookieAppNavigationBar(
                navController = navController,
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = CookieNavItem.LIST.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            composable(route = CookieNavItem.HOME.name) {
                HomeScreen()
            }
            composable(route = CookieNavItem.LIST.name) {
                ListScreen(cookiesList = getCookiesList())
            }
            composable(route = CookieNavItem.DETAILS.name) {
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
fun CookieAppNavigationBar(
    navController: NavHostController,
) {
    val navItems = CookieNavItem.entries
    /** Bar for low dp devices **/
    NavigationBar {
        navItems.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(navigationItem.name) },
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