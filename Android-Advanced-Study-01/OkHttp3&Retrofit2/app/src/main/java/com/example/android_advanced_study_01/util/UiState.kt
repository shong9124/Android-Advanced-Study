package com.example.android_advanced_study_01.util

sealed class UiState<out T>{
    data object Loading: UiState<Nothing>()
    data class Success<out T>(val data: T): UiState<T>()
    data class Failure(val message: String?): UiState<Nothing>()
}