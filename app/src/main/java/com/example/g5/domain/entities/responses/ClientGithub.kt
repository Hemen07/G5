package com.example.g5.domain.entities.responses

/**
 * ClientGithub
 *---------------------------------
 * No var
 * No null
 * --------------------------------
 */
data class ClientGithub internal constructor(
    val username: String,
    val name: String,
    val url: String,
    val avatar: String,
    val repo: ClientRepo
) {
    data class ClientRepo(
        val name: String,
        val description: String,
        val url: String
    )
}