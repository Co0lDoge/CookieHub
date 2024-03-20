package com.dogiumlabs.cookiehub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.DateRange
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme
import com.dogiumlabs.cookiehub.data.Cookie
import com.dogiumlabs.cookiehub.data.CookieDataSource

@Composable
fun DetailsScreen(
    cookie: Cookie,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            imageVector = Icons.Sharp.DateRange,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "This is recipe of ${stringResource(cookie.name)}",
            style = MaterialTheme.typography.titleMedium)
        Text(
            text = stringResource(cookie.description),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview() {
    CookieHubTheme {
        DetailsScreen(cookie = CookieDataSource.defaultCookie)
    }
}