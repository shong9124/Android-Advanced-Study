package com.example.android_advanced_study_01.data.dto

data class WeatherDTO(
    val serviceKey: String,
    val pageNo: Int,
    val numOfRows: Int,
    val dataType: String = "JSON",
    val base_date: String,
    val base_time: String,
    val nx: Int,
    val ny: Int
)
