package com.gaming.kotlinpracticeproject

interface Image{
    fun display()
}

class RealImage(private val fileName:String): Image{

    init {
        loadFromDisk()
    }

    private fun loadFromDisk(){
        println("Loading $fileName")
    }

    override fun display() {
        println("Displaying $fileName")
    }

}

class ProxyImage(private val fileName: String): Image{
    private var realImage: RealImage ?= null

    override fun display() {

        if(realImage == null)
            realImage = RealImage(fileName)

        realImage?.display()
    }
}

// Usage
fun main(){
    val image = ProxyImage("testing.jpg")
    image.display() // Loads and displays only when needed
}