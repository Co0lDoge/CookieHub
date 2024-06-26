package com.dogiumlabs.cookiehub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.dogiumlabs.cookiehub.data.CookieDataSource
import com.dogiumlabs.cookiehub.ui.theme.CookieHubTheme

@Composable
fun ListScreen(
    cookiesList: List<Cookie>,
    onItemClick: (Cookie) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(cookiesList) {cookie ->
            CookieCard(
                cookie = cookie,
                onClick = onItemClick
            )
        }
    }
}

@Composable
fun CookieCard(
    cookie: Cookie,
    onClick: (Cookie) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = { onClick(cookie) },
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
        ListScreen(
            cookiesList = CookieDataSource.getCookiesList(),
            onItemClick = { }
        )
    }
}

@Composable
@Preview
fun CardPreview() {
    CookieHubTheme {
        CookieCard(
            cookie = CookieDataSource.getCookiesList()[0],
            onClick = { }
        )
    }
}