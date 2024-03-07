package com.dogiumlabs.cookiehub.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cookie(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
