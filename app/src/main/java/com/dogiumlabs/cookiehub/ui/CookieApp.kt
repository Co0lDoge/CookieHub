package com.dogiumlabs.cookiehub.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dogiumlabs.cookiehub.data.getCookiesList
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme
import com.dogiumlabs.cookiehub.ui.utils.CookieNavItem


@Composable
fun CookieApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CookieNavItem.valueOf(
        backStackEntry?.destination?.route ?: CookieNavItem.LIST.name
    )

    Scaffold(
        topBar = {
            CookieAppTopBar(stringResource(currentScreen.title))
        },
        bottomBar = {
            CookieAppNavigationBar(
                navController = navController,
                screenName = currentScreen.name
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
fun CookieAppTopBar(title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}

@Composable
fun CookieAppNavigationBar(
    navController: NavHostController,
    screenName: String
) {
    /** Bar for low dp devices **/

    // List of all navigation items
    val navItems = CookieNavItem.entries

    NavigationBar {
        navItems.forEach { navigationItem ->
            NavigationBarItem(
                selected = screenName == navigationItem.name,
                onClick = { navController.navigate(navigationItem.name) },
                icon = {
                    Icon(
                        imageVector = if (screenName == navigationItem.name) {
                            navigationItem.selectedIcon
                        } else {
                            navigationItem.unselectedIcon
                        },
                        contentDescription = null
                    ) },
                label = { Text(stringResource(navigationItem.title)) }
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