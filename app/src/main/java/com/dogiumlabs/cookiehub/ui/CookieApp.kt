package com.dogiumlabs.cookiehub.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dogiumlabs.cookiehub.R
import com.dogiumlabs.cookiehub.model.CookieHubViewModel
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme
import com.dogiumlabs.cookiehub.ui.utils.CookieContentType
import com.dogiumlabs.cookiehub.ui.utils.CookieNavItem
import com.dogiumlabs.cookiehub.ui.utils.CookieNavigationType


@Composable
fun CookieApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController()
) {
    // Values related to navigation
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CookieNavItem.valueOf(
        backStackEntry?.destination?.route ?: CookieNavItem.Recipes.name
    )

    // List of all navigation items
    val navItems = CookieNavItem.entries

    // Values that defines layout of navigation and screens
    val (navigationType, contentType) = when (windowSize) {
        WindowWidthSizeClass.Compact -> Pair(
            CookieNavigationType.BOTTOM_NAVIGATION, CookieContentType.LIST_ONLY
        )

        WindowWidthSizeClass.Medium -> Pair(
            CookieNavigationType.NAVIGATION_RAIL, CookieContentType.LIST_ONLY
        )

        WindowWidthSizeClass.Expanded -> Pair(
            CookieNavigationType.NAVIGATION_RAIL, CookieContentType.LIST_AND_DETAILS
        )

        else -> Pair(
            CookieNavigationType.BOTTOM_NAVIGATION, CookieContentType.LIST_ONLY
        )
    }

    val viewModel: CookieHubViewModel = viewModel()
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CookieAppTopBar(
                // Show back button if only details list is present (contentType is LIST_ONLY)
                title = stringResource(currentScreen.title),
                isShowingNavButton = uiState.value.isShowingDetails
                        && contentType == CookieContentType.LIST_ONLY
                        && currentScreen == CookieNavItem.Recipes,
                onIconClick = { viewModel.navigateToList() }
            )
        },
        bottomBar = {
            if (navigationType == CookieNavigationType.BOTTOM_NAVIGATION)
                CookieAppNavigationBar(
                    navController = navController,
                    navItems = navItems,
                    screenName = currentScreen.name
                )
        }
    ) { paddingValues ->
        Row(
            modifier = Modifier.padding(paddingValues)
        ) {
            if (navigationType == CookieNavigationType.NAVIGATION_RAIL)
                CookieAppNavigationRail(
                    navController = navController,
                    navItems = navItems,
                    screenName = currentScreen.name
                )
            NavHost(
                navController = navController,
                startDestination = CookieNavItem.Recipes.name,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                composable(route = CookieNavItem.HOME.name) {
                    HomeScreen()
                }
                composable(route = CookieNavItem.Recipes.name) {
                    RecipesScreen(
                        cookiesList = uiState.value.cookieList,
                        currentCookie = uiState.value.currentCookie,
                        isShowingDetails = uiState.value.isShowingDetails,
                        onBackPressed = { viewModel.navigateToList() },
                        onListItemClick = { viewModel.navigateToDetails(it) },
                        contentType = contentType
                    )
                }
                composable(route = CookieNavItem.CLICKER.name) {
                    ClickerScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CookieAppTopBar(
    title: String,
    isShowingNavButton: Boolean,
    onIconClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            AnimatedVisibility(visible = isShowingNavButton) {
                IconButton(onClick = onIconClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button),
                    )
                }
            }
        }
    )
}

@Composable
fun CookieAppNavigationBar(
    navController: NavHostController,
    navItems: List<CookieNavItem>,
    screenName: String
) {
    /** Bar for low dp devices **/
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
                    )
                },
                label = { Text(stringResource(navigationItem.title)) }
            )
        }
    }
}

@Composable
fun CookieAppNavigationRail(
    navController: NavHostController,
    navItems: List<CookieNavItem>,
    screenName: String
) {
    /** Bar for medium dp devices **/
    NavigationRail {
        navItems.forEach { navigationItem ->
            NavigationRailItem(
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
                    )
                },
                label = { Text(stringResource(navigationItem.title)) }
            )
        }
    }
}

@Composable
@Preview
fun CookieAppCompactPreview() {
    CookieHubTheme {
        CookieApp(WindowWidthSizeClass.Compact)
    }
}

@Composable
@Preview(widthDp = 600)
fun CookieAppMediumPreview() {
    CookieHubTheme {
        CookieApp(WindowWidthSizeClass.Medium)
    }
}

@Composable
@Preview(widthDp = 800)
fun CookieAppExpandedPreview() {
    CookieHubTheme {
        CookieApp(WindowWidthSizeClass.Expanded)
    }
}