package com.example.g5.domain.usecases

import com.example.g5.data.repositories.gittrendingrepo.FetchGitTrendingRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * GetGitUseCase
 *
 * + Get the Trending repositories
 *
 * TODO - Normally we use interface, in that case you have to provide via DI
 */
@Singleton
class GetGitUseCase @Inject constructor(
    private val fetchGitTrendingRepository: FetchGitTrendingRepository
) {

    suspend fun invoke() = fetchGitTrendingRepository.getTrendingRepositories()
}