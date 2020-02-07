package com.bryanollivie.sdk.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Owner(

    @Json(name = "id")
    val id: Int,

    @Json(name = "login")
    val login: String,

    @Json(name = "avatar_url")
    val avatar_url: String,

    @Json(name = "url")
    val url: String

)