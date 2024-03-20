package com.dogiumlabs.cookiehub.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dogiumlabs.cookiehub.data.Cookie
import com.dogiumlabs.cookiehub.data.CookieDataSource
import com.dogiumlabs.cookiehub.ui.components.DetailsScreen
import com.dogiumlabs.cookiehub.ui.components.ListScreen
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme
import com.dogiumlabs.cookiehub.ui.utils.CookieContentType

@Composable
fun RecipesScreen(
    cookiesList: List<Cookie>,
    currentCookie: Cookie,
    isShowingDetails: Boolean,
    onListItemClick: (Cookie) -> Unit,
    onBackPressed: () -> Unit,
    contentType: CookieContentType,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        // if windowSize is Expanded, show both list of cookies and it's details
        if (contentType == CookieContentType.LIST_AND_DETAILS) {
            ListScreen(
                cookiesList = cookiesList,
                onItemClick = onListItemClick,
                modifier = Modifier.weight(2f)
            )
            DetailsScreen(
                cookie = currentCookie,
                modifier = Modifier.weight(3f)
            )
        }
        else {
            AnimatedVisibility(visible = !isShowingDetails) {
                ListScreen(
                    cookiesList = cookiesList,
                    onItemClick = onListItemClick,
                    modifier = Modifier
                )
            }
            AnimatedVisibility(visible = isShowingDetails) {
                BackHandler {
                    // Returns to cookies list if only details are shown
                    onBackPressed()
                }
                DetailsScreen(
                    cookie = currentCookie,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipesScreenCompactPreview() {
    CookieHubTheme {
        RecipesScreen(
            cookiesList = CookieDataSource.getCookiesList(),
            currentCookie = CookieDataSource.defaultCookie,
            isShowingDetails = false,
            onListItemClick = {},
            onBackPressed = {},
            contentType = CookieContentType.LIST_ONLY
        )
    }
}

@Composable
@Preview(widthDp = 1000, showBackground = true)
fun RecipesScreenExpandedPreview() {
    CookieHubTheme {
        RecipesScreen(
            cookiesList = CookieDataSource.getCookiesList(),
            currentCookie = CookieDataSource.defaultCookie,
            isShowingDetails = false,
            onListItemClick = {},
            onBackPressed = {},
            contentType = CookieContentType.LIST_AND_DETAILS
        )
    }
}