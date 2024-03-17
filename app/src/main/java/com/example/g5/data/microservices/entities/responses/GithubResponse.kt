package com.example.g5.data.microservices.entities.responses


import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class Github(
    var username: String? = null,
    var name: String? = null,
    var url: String? = null,
    var avatar: String? = null,
    var repo: Repo? = null

) : Parcelable {

    @JsonClass(generateAdapter = true)
    @Parcelize
    data class Repo(
        var name: String? = null,
        var description: String? = null,
        var url: String? = null
    ) : Parcelable
}



