package com.dogiumlabs.cookiehub.model

import com.dogiumlabs.cookiehub.data.Cookie
import com.dogiumlabs.cookiehub.data.CookieDataSource

data class CookieHubUiState(
    val cookieList: List<Cookie> = CookieDataSource.getCookiesList(),
    val currentCookie: Cookie = CookieDataSource.defaultCookie,
    val isShowingDetails: Boolean = false
)