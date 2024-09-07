package com.example.tetsideaplatform.ui.presentation

import com.example.tetsideaplatform.domain.model.Item

sealed class MainScreenState {

    object Initial : MainScreenState()

    data class Items(
        val items: List<Item>,
        val search: String
    ) : MainScreenState()

}