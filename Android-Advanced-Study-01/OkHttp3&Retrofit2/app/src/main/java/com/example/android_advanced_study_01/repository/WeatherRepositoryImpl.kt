package com.example.android_advanced_study_01.repository

import android.util.Log
import com.example.android_advanced_study_01.data.dto.WeatherResponse
import com.example.android_advanced_study_01.data.remote.RetrofitClient
import com.example.android_advanced_study_01.data.remote.service.WeatherService
import org.json.JSONObject

class WeatherRepositoryImpl : WeatherRepository {
    private val service = RetrofitClient.getInstance().create(WeatherService::class.java)

    override suspend fun getWeather(
        serviceKey: String,
        pageNo: Int,
        numOfRows: Int,
        dataType: String,
        base_date: String,
        base_time: String,
        nx: Int,
        ny: Int
    ): Result<WeatherResponse> {
        val res
        = service.getWeather(serviceKey, pageNo, numOfRows, dataType, base_date, base_time, nx, ny)

        return if (res.isSuccessful) {
            if (res.body() == null) {
                Result.success(listOf())
            }
            else {
                Result.success(res.body()!!)
            }
        }
        else {
            val errorMsg = JSONObject(res.errorBody()!!.string()).getString("msg")
            Result.failure(java.lang.Exception(errorMsg))
        }
    }
}