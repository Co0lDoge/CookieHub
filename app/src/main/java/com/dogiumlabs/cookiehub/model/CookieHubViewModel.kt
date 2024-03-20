package com.dogiumlabs.cookiehub.model

import androidx.lifecycle.ViewModel
import com.dogiumlabs.cookiehub.data.CookieDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CookieHubViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        CookieHubUiState(
            cookieList = CookieDataSource.getCookiesList()
        )
    )

    val uiState: StateFlow<CookieHubUiState> = _uiState
}