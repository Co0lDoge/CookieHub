package com.dogiumlabs.cookiehub.model

import androidx.lifecycle.ViewModel
import com.dogiumlabs.cookiehub.data.Cookie
import com.dogiumlabs.cookiehub.data.CookieDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CookieHubViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        CookieHubUiState(
            cookieList = CookieDataSource.getCookiesList(),
            currentCookie = CookieDataSource.defaultCookie,
            isShowingDetails = false
        )
    )

    val uiState: StateFlow<CookieHubUiState> = _uiState

    // This updates currentCookie when relevant cookie card is clicked
    // and changes screens between list and details if screenWidth is extended
    fun navigateToDetails(selectedCookie: Cookie) {
        _uiState.update {
            it.copy(
                isShowingDetails = true,
                currentCookie = selectedCookie
            )
        }
    }

    fun navigateToList() {
        _uiState.update {
            it.copy(
                isShowingDetails = false,
            )
        }
    }
}