package com.example.android_advanced_study_01.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_advanced_study_01.data.dto.ServiceKey
import com.example.android_advanced_study_01.data.dto.WeatherResponse
import com.example.android_advanced_study_01.repository.WeatherRepositoryImpl
import com.example.android_advanced_study_01.util.UiState
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val weatherRepoImpl = WeatherRepositoryImpl()
    private val _weatherState = MutableLiveData<UiState<List<WeatherResponse>>>(UiState.Loading)
    val weatherState get() = _weatherState

    fun getWeatherFun(baseDate: String, baseTime: String) {
        _weatherState.value = UiState.Loading

        viewModelScope.launch {
            try {
                weatherRepoImpl.getWeather(
                    ServiceKey.SERVICE_KEY,
                    10,
                    10,
                    "JSON",
                    baseDate,
                    baseTime,
                    37, 126
                ).onSuccess {
                    _weatherState.value = UiState.Success(it)
                }.onFailure {
                    _weatherState.value = UiState.Failure(it.message)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
                _weatherState.value = UiState.Failure(e.message)
            }
        }
    }
}