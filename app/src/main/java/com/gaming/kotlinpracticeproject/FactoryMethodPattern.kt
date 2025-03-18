package com.gaming.kotlinpracticeproject

interface Animal {
    fun sound(): String
}

class Dog: Animal{
    override fun sound(): String {
        return "Woof!"
    }
}

class Cat: Animal{
    override fun sound(): String {
        return "Meow!"
    }
}

class AnimalFactory{
    fun createAnimal(type:String):Animal{
        return when(type){
            "dog" -> Dog()
            "cat" -> Cat()
            else -> throw IllegalArgumentException("Unknown animal")
        }
    }
}

// Usage
fun main(){
    val factory = AnimalFactory()
    val dog = factory.createAnimal("dog")
    println(dog.sound())//Woof!
}