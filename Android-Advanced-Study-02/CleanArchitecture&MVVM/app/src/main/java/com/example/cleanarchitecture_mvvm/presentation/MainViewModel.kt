package com.example.cleanarchitecture_mvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture_mvvm.domain.model.GithubRepo
import com.example.cleanarchitecture_mvvm.domain.usecase.GetGithubReposUseCase
import com.example.cleanarchitecture_mvvm.presentation.base.BaseViewModel

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
): BaseViewModel() {

    private val _githubRepositories = MutableLiveData<List<GithubRepo>>()
    val githubRepositories: LiveData<List<GithubRepo>> = _githubRepositories

    fun getGithubRepositories(owner: String) {
        getGithubReposUseCase(owner, viewModelScope) {
            _githubRepositories.value = it
        }
    }
}