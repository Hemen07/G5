package com.example.g5.di.app.api

import com.example.g5.data.microservices.api.GitTrendingRepoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

private const val TAG = "G5-RepositoryModule : "


/**
 * ApiModule module
 * ------------------
 */
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    /**
     * Provides Get trending repository API [GitTrendingRepoApi]
     * @param retrofit : [Retrofit] instance
     * @return [GitTrendingRepoApi] instance
     */
    @Provides
    @Singleton
    fun provideGitTrendingRepoApi(retrofit: Retrofit): GitTrendingRepoApi {
        return retrofit.create(GitTrendingRepoApi::class.java)
    }
}