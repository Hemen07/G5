package com.example.g5.data.microservices.mappers

import android.util.Log
import com.example.g5.data.microservices.entities.responses.Github
import com.example.g5.domain.entities.responses.ClientGithub

private const val TAG = "G5-GithubResponseMapper : "


/**
 * Map to client
 *
 * Take care of null
 * Assign empty values
 */
internal fun List<Github?>.mapToClient(): List<ClientGithub> {
    Log.d(TAG, "mapToClient: ")
    val clientGithubList = mutableListOf<ClientGithub>()
    this.map { itemData ->
        clientGithubList.add(
            element = ClientGithub(
                avatar = itemData?.avatar ?: "",
                name = itemData?.name ?: "",
                repo = itemData?.repo.mapToClient(),
                url = itemData?.url ?: "",
                username = itemData?.username ?: ""
            )
        )
    }
    return clientGithubList
}

private fun Github.Repo?.mapToClient(): ClientGithub.ClientRepo {
    return if (this == null) {
        ClientGithub.ClientRepo(
            description = "",
            name = "",
            url = ""
        )
    } else {
        ClientGithub.ClientRepo(
            description = this.description ?: "",
            name = this.name ?: "",
            url = this.url ?: ""
        )
    }
}