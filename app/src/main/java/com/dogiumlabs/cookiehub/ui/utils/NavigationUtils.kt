package com.dogiumlabs.cookiehub.ui.utils

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.dogiumlabs.cookiehub.R

enum class CookieNavItem(
    @StringRes val title: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    /** This class defines navigation routes. **/
    HOME(
        title = R.string.home,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    Recipes(
        title = R.string.recipes,
        selectedIcon = Icons.Filled.List,
        unselectedIcon = Icons.Outlined.List
    ),
    CLICKER(
        title = R.string.clicker,
        selectedIcon = Icons.Filled.ThumbUp,
        unselectedIcon = Icons.Outlined.ThumbUp
    )
}

enum class CookieNavigationType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL
}

enum class CookieContentType {
    LIST_ONLY, LIST_AND_DETAILS
}