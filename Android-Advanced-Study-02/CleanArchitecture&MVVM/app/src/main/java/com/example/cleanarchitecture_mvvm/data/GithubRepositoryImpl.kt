package com.example.cleanarchitecture_mvvm.data

import com.example.cleanarchitecture_mvvm.domain.repository.GithubRepository
import com.example.cleanarchitecture_mvvm.data.source.GithubRemoteSource
import com.example.cleanarchitecture_mvvm.domain.model.GithubRepo

class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource: GithubRemoteSource
) : GithubRepository {

    override suspend fun getRepos(owner: String): List<GithubRepo> {
        return githubRemoteSource.getRepos(owner)
    }
}