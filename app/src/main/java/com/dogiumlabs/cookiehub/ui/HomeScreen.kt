package com.dogiumlabs.cookiehub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dogiumlabs.cookiehub.R
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .padding(64.dp)
                .shadow(8.dp)
                .height(256.dp)
                .width(256.dp)
        ) {
            Image(
                imageVector = Icons.Rounded.AccountBox,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        top = 32.dp,
                        bottom = 32.dp,
                        start = 8.dp,
                        end = 8.dp
                    )
                    .height(192.dp)
                    .width(192.dp)
            )
        }

        Text(
            text = stringResource(R.string.home_screen_error_text),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    CookieHubTheme {
        HomeScreen()
    }
}