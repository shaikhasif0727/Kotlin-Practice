package com.gaming.kotlinpracticeproject

interface Coffee{
    fun cost():Double
    fun description():String
}

class SimpleCoffee:Coffee{
    override fun cost(): Double {
        return 5.0
    }

    override fun description(): String {
        return "Simple Coffee"
    }
}

class MilkDecorator(private val coffee: Coffee):Coffee{
    override fun cost(): Double {
        return coffee.cost() + 2.0
    }

    override fun description(): String {
        return "${coffee.description()}, Milk"
    }
}

fun main(){
    val simpleCoffee = SimpleCoffee()
    val milkCoffee = MilkDecorator(simpleCoffee)

    println(milkCoffee.description()) // Simple Coffee, Milk
    println(milkCoffee.cost()) // 7.0
}