package com.example.cleanarchitecture_mvvm.domain.repository

import com.example.cleanarchitecture_mvvm.domain.model.GithubRepo

interface GithubRepository {
    suspend fun getRepos(owner: String): List<GithubRepo>
}