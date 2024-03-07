package com.dogiumlabs.cookiehub.data

import androidx.compose.ui.res.stringResource
import com.dogiumlabs.cookiehub.R

fun getCookiesList(): List<Cookie> {
    return listOf<Cookie>(
        Cookie(
            name = R.string.cookie_name_1,
            description = R.string.cookie_description_1,
            image = R.drawable.ic_launcher_background
        ),
        Cookie(
            name = R.string.cookie_name_2,
            description = R.string.cookie_description_2,
            image = R.drawable.ic_launcher_background
        )
    )
}