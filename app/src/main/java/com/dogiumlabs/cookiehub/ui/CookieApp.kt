package com.dogiumlabs.cookiehub.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dogiumlabs.cookiehub.data.getCookiesList

enum class CookieApp(/***TODO @StringRes title***/) {
    HOME,
    LIST,
    DETAILS
}

@Composable
fun CookieApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = CookieApp.LIST.name,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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

@Composable
fun CookieAppNavigationBar() {
    //TODO
}

@Composable
fun CookieAppNavigationRail() {
    //TODO
}

@Composable
fun CookieAppNavigationDrawer() {
    //TODO
}