package com.example.viewmodel.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodel.util.UiState

class TextViewModel : ViewModel() {
    private val _textState = MutableLiveData<UiState<String>>(UiState.Loading)
    val textState get() = _textState

    // 성공 했을 경우 msg 가져 오기
    fun getChangeText(msg: String) {
        _textState.value = UiState.Success(msg)
    }
    // 로딩 중인 경우
    fun setLoading() {
        _textState.value = UiState.Loading
    }
    // 실패한 경우
    fun failToGetChangeText(code: Int, msg: String) {
        _textState.value = UiState.Failure(code, msg)
    }
}