package com.dogiumlabs.cookiehub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dogiumlabs.cookiehub.data.Cookie
import com.dogiumlabs.cookiehub.data.getCookiesList
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme

@Composable
fun ListScreen(
    cookiesList: List<Cookie>
) {
    Column {
        cookiesList.forEach { cookie ->
            CookieCard(cookie)
        }
    }
}

@Composable
fun CookieCard(
    cookie: Cookie,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(10f)
            ) {
                Text(
                    text = stringResource(cookie.name),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(cookie.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(cookie.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ListScreenPreview() {
    CookieHubTheme {
        ListScreen(getCookiesList())
    }
}

@Composable
@Preview
fun CardPreview() {
    CookieHubTheme {
        CookieCard(getCookiesList()[0])
    }
}