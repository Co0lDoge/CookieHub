package com.dogiumlabs.cookiehub.data

import com.dogiumlabs.cookiehub.R

object CookieDataSource {
    public fun getCookiesList(): List<Cookie> {
        return listOf(
            Cookie(
                name = R.string.cookie_name_1,
                description = R.string.cookie_description_1,
                image = R.drawable.ic_launcher_background
            ),
            Cookie(
                name = R.string.cookie_name_2,
                description = R.string.cookie_description_2,
                image = R.drawable.ic_launcher_background
            ),
            Cookie(
                name = R.string.cookie_name_3,
                description = R.string.cookie_description_3,
                image = R.drawable.ic_launcher_background
            ),
            Cookie(
                name = R.string.cookie_name_4,
                description = R.string.cookie_description_4,
                image = R.drawable.ic_launcher_background
            ),
            Cookie(
                name = R.string.cookie_name_5,
                description = R.string.cookie_description_5,
                image = R.drawable.ic_launcher_background
            ),
            Cookie(
                name = R.string.cookie_name_6,
                description = R.string.cookie_description_6,
                image = R.drawable.ic_launcher_background
            ),
            Cookie(
                name = R.string.cookie_name_7,
                description = R.string.cookie_description_7,
                image = R.drawable.ic_launcher_background
            ),
            Cookie(
                name = R.string.cookie_name_8,
                description = R.string.cookie_description_8,
                image = R.drawable.ic_launcher_background
            ),
        )
    }
}
