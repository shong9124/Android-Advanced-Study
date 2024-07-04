package com.example.android_advanced_study_01.repository

import com.example.android_advanced_study_01.data.dto.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(
        serviceKey: String,
        pageNo: Int,
        numOfRows: Int,
        dataType: String = "JSON",
        base_date: String,
        base_time: String,
        nx: Int,
        ny: Int
    ) : Result<WeatherResponse>
}