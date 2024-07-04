package com.example.android_advanced_study_01.data.dto

data class WeatherResponse(
    val resultCode: Int,
    val resultMsg: String,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
    val dataType: String,
    val baseDate: String,
    val baseTime: String,
    val fcstDate: String,
    val fcstTime: String,
    val category: String,
    val fcstValue: Int,
    val nx: Int,
    val ny: Int
)
