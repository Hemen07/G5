package com.example.g5.data.repositories.gittrendingrepo

import android.util.Log
import com.example.g5.data.microservices.mappers.apiMapToClient
import com.example.g5.data.microservices.mappers.mapToClient
import com.example.g5.data.microservices.service.GitTrendingRepositoriesService
import com.example.g5.domain.common.ClientApiResult
import com.example.g5.domain.entities.responses.ClientGithub
import javax.inject.Inject

private const val TAG = "G5-GetTrendingRepoImpl : "

/**
 * Get trending repo Impl
 */
class FetchGitTrendingRepoImpl @Inject constructor(
    private val gitTrendingRepositoriesService: GitTrendingRepositoriesService
) : FetchGitTrendingRepository {

    override suspend fun getTrendingRepositories(): ClientApiResult<List<ClientGithub>> {
        Log.d(TAG, "getTrendingRepositories: +++++++++")
        return gitTrendingRepositoriesService
            .get()
            .apiMapToClient {
                this.mapToClient()
            }
    }
}

