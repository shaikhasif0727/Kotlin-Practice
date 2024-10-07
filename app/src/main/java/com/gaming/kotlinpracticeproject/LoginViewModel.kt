package com.gaming.kotlinpracticeproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(
    private val navigator: Navigator
) : ViewModel() {

    fun login(){
        viewModelScope.launch {
            navigator.navigate(
                destination = Destination.HomeGraph,
                navOptionsBuilder = {
                    popUpTo(Destination.AuthGraph){
                        inclusive = true
                    }
                }
            )
        }
    }
}