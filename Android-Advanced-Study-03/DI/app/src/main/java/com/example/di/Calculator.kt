package com.example.di

import javax.inject.Inject

class Calculator @Inject constructor() {
    fun addNumberTwo(number: Int): Int{
        return number + 2
    }
}