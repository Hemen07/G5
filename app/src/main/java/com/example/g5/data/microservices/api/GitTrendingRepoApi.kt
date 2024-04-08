package com.example.g5.data.microservices.api

import com.example.g5.data.microservices.entities.responses.Github
import retrofit2.Response
import retrofit2.http.GET


/**
 * GitTrendingRepoApi
 * ====================
 *
 */
interface GitTrendingRepoApi {

    /**
     * Fetch Github Trending Repos based on weekly - kotlin language
     * @return [Response] list of Github (nullable)
     */
    @GET("developers?language=kotlin&since=weekly")
    suspend fun fetchGitTrendingRepos(): Response<List<Github?>>
}


/*

https://api.gitterapp.com/developers?language=kotlin&since=weekly


 */