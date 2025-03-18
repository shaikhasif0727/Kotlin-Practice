package com.gaming.kotlinpracticeproject


// ViewModel (Handles Business Logic)
private class UserViewModel{
    private var user:User?=null

    fun loadUser(){
        user = User("John Deo") //Simulating data fetch
    }

    fun getUser():User?{
        return user
    }

}

// Usage
fun main(){
    val viewModel  = UserViewModel()
    println(viewModel.getUser()?.name?:"No user loaded")
    //No user loaded

    viewModel.loadUser()
    println(viewModel.getUser()?.name) // John Deo


}