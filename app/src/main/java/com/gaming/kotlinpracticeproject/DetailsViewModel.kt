package com.gaming.kotlinpracticeproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val navigator: Navigator
) : ViewModel() {

    fun goBack(){
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }
}