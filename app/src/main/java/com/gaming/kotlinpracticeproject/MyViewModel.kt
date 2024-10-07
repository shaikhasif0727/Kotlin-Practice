package com.gaming.kotlinpracticeproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading
        .onStart {
            loadData()
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),false)

    fun loadData(){
        println("Loading Data...")
        viewModelScope.launch {
            _isLoading.value = true
            delay(3000L)
            _isLoading.value = false
        }
    }

}