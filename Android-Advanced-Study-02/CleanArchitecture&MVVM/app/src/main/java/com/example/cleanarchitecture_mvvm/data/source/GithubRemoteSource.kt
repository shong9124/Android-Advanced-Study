package com.example.cleanarchitecture_mvvm.data.source

import com.example.cleanarchitecture_mvvm.data.model.GithubRepoRes
import com.example.cleanarchitecture_mvvm.data.service.GithubService

interface GithubRemoteSource {
    suspend fun getRepos(owner: String): List<GithubRepoRes>
}

class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService
) : GithubRemoteSource {

    override suspend fun getRepos(owner: String): List<GithubRepoRes> {
        return githubService.getRepos(owner)
    }
}