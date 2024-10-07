package com.gaming.kotlinpracticeproject.di

import com.gaming.kotlinpracticeproject.DefaultNavigator
import com.gaming.kotlinpracticeproject.Destination
import com.gaming.kotlinpracticeproject.DetailsViewModel
import com.gaming.kotlinpracticeproject.HomeViewModel
import com.gaming.kotlinpracticeproject.LoginViewModel
import com.gaming.kotlinpracticeproject.Navigator
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<Navigator> {
        DefaultNavigator(startDestination = Destination.AuthGraph)
    }

    viewModelOf(::LoginViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailsViewModel)
}

