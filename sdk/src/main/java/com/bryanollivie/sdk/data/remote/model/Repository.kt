package com.bryanollivie.sdk.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Repository(

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "full_name")
    val full_name: String,

    @Json(name = "owner")
    val owner: Owner,

    @Json(name = "description")
    val description: String,

    @Json(name = "html_url")
    val html_url: String,
/*
    @Json(name = "fork")
    val fork: String,*/

    @Json(name = "url")
    val url: String,

    @Json(name = "stargazers_count")
    val stargazers_count: Int,

    @Json(name = "forks")
    val forks: Int


)