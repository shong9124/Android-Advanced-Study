package com.example.android_advanced_study_01.data.remote

import com.example.android_advanced_study_01.util.PrettyJsonLogger
import com.facebook.shimmer.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?"
    private var instance: Retrofit? = null
    private val gson = GsonBuilder().setLenient().create()

    // Interceptor를 사용 -> 모든 활동 모니터링
    private val loggingInterceptor = if (!BuildConfig.DEBUG) {
        HttpLoggingInterceptor(PrettyJsonLogger()).setLevel(
            HttpLoggingInterceptor.Level.BODY)
    } else {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }

    // Interceptor 추가
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    fun getInstance(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }
        return instance!!
    }
}