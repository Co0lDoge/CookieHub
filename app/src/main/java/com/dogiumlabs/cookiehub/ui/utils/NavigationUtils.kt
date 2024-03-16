package com.dogiumlabs.cookiehub.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class CookieNavItem(
    val title: String,
    val selectedIcon: ImageVector?,
    val unselectedIcon: ImageVector
) {
    /** This class defines navigation routes.
     * For ui navigation items visit NavigationUtils **/
    HOME(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    LIST(
        title = "Recipes",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    DETAILS(
        title = "Clicker",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )
}