package com.gaming.kotlinpracticeproject

class UserData private constructor(
    val name: String,
    val age: Int,
    val email: String
) {
    class Builder {
        private var name: String = ""
        private var age: Int = 0
        private var email: String = ""

        fun name(name: String) = apply { this.name = name }
        fun age(age: Int) = apply { this.age = age }
        fun email(email: String) = apply { this.email = email }

        fun build() = UserData(name, age, email)
    }
}

// Usage
fun main(){
    val user = UserData.Builder()
        .name("John Deo")
        .age(30)
        .email("john@example.com")
        .build()
}