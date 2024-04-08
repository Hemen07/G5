package com.example.g5.data.microservices.service

import com.example.g5.data.microservices.api.GitTrendingRepoApi
import com.example.g5.data.microservices.common.BaseApi
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "G5-GitTrendingRepositoriesService : "

/**
 * Git trending repositories
 */
@Singleton
class GitTrendingRepositoriesService @Inject constructor(
    private val gitTrendingRepoApi: GitTrendingRepoApi
) : BaseApi() {

    @Throws(Exception::class)
    suspend fun get() = handleApi {
        gitTrendingRepoApi.fetchGitTrendingRepos()
    }

}