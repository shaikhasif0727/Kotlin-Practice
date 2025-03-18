package com.gaming.kotlinpracticeproject

// View (interface)
interface UserViewPresenter {
    fun showUser(name:String)
}

class UserPresenter(private val view:UserViewPresenter){
    fun loadUser(){
        val user = User("Jane Deo")// Simulating data fetch
        view.showUser(user.name)
    }
}

// View Implementation (for Console Output)
class ConsoleViewPresenter : UserViewPresenter{
    override fun showUser(name: String) {
        println(name)
    }
}

// Usage
fun main(){
    val view = ConsoleViewPresenter()
    val presenter = UserPresenter(view)

    println("Before loading user...")
    presenter.loadUser() // Jane Deo
}