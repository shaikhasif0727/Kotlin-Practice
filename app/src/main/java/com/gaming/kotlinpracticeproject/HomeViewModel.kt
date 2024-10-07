package com.gaming.kotlinpracticeproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel(
    private val navigator: Navigator
) : ViewModel() {

    fun navigationToDetails(id:String){
        viewModelScope.launch {
            navigator.navigate(
                destination = Destination.DetailsScreen(id),
            )
        }
    }
}