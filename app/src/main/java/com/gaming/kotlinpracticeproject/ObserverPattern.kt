package com.gaming.kotlinpracticeproject

interface Observer {
    fun update(temperature: Float)
}

class WeatherStation{
    private val observers = mutableListOf<Observer>()
    private var temperature: Float = 0f

    fun addObserve(observer: Observer){
        observers.add(observer)
    }

    fun setTemperature(temp: Float){
        temperature = temp
        notifyObservers()
    }

    private fun notifyObservers(){
        observers.forEach { it.update(temperature) }
    }
}

class WeatherDisplay: Observer{
    override fun update(temperature: Float) {
        println("Temperature updated: ${temperature}oC")
    }

}

fun main(){
    val weatherStation = WeatherStation()
    val display = WeatherDisplay()

    weatherStation.addObserve(display)
    weatherStation.setTemperature(25.5f)
}