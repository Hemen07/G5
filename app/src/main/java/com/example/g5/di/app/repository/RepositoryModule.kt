package com.example.g5.di.app.repository

import android.util.Log
import com.example.g5.data.microservices.api.GitTrendingRepoApi
import com.example.g5.data.microservices.service.GitTrendingRepositoriesService
import com.example.g5.data.repositories.gittrendingrepo.FetchGitTrendingRepoImpl
import com.example.g5.data.repositories.gittrendingrepo.FetchGitTrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val TAG = "G5-RepositoryModule : "


/**
 * Repository module
 * ------------------
 * All repositories related here
 * Obviously connected to [UseCaseModule]
 *
 *
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    init {
        Log.i(TAG, "init: ")
    }


    /**
     * Provides Get trending repository
     * Using API [GitTrendingRepoApi]
     * @param gitTrendingRepositoriesService : [GitTrendingRepositoriesService] instance
     * @return
     */
    @Provides
    @Singleton
    fun provideGetTrendingRepository(gitTrendingRepositoriesService: GitTrendingRepositoriesService): FetchGitTrendingRepository {
        return FetchGitTrendingRepoImpl(gitTrendingRepositoriesService = gitTrendingRepositoriesService)
    }


}