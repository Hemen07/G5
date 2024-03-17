package com.example.g5.data.repositories.gittrendingrepo

import com.example.g5.domain.common.ClientApiResult
import com.example.g5.domain.entities.responses.ClientGithub

interface FetchGitTrendingRepository {

    suspend fun getTrendingRepositories(): ClientApiResult<List<ClientGithub>>
}