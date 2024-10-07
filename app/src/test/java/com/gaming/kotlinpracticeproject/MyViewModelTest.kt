package com.gaming.kotlinpracticeproject

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MyViewModelTest {

    private lateinit var viewModel: MyViewModel

    @Before
    fun setUp() {
        viewModel = MyViewModel()
    }

    @Test
    fun testSomething() {
        runBlocking {
            viewModel.isLoading.collect {
                println(it)
            }
        }
    }
}