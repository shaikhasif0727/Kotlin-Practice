package com.gaming.kotlinpracticeproject

// View (Handles UI)
private class UserView{
    fun displayUser(name:String){
        println("User: $name")
    }
}

// Controller (Manages Logic and Update View)
class UserController(private val view:UserViewPresenter){
    private var user:User?=null

    fun loadUser(){
        user = User("Alice")// Simulating data fetch
        updateView()
    }

    private fun updateView(){
        user?.let {
            view.displayUser(it.name)
        }
    }

}

// Usage
fun main(){
    val view = UserViewPresenter()
    val controller = UserController(view)

    println("Before loading user...")
    controller.loadUser() // user: Alice
}