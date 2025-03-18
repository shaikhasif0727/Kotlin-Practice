package com.gaming.kotlinpracticeproject

object DatabaseManager{
    private val connection  = "Database Connection"

    fun getConnection(): String{
        return connection
    }
}

// Usage
fun main(){
    val db1 = DatabaseManager.getConnection()
    val db2 = DatabaseManager.getConnection()
    println(db1 == db2) // Always true
}