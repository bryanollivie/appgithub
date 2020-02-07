package com.bryanollivie.sdk.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BodyResponse(

    @Json(name = "total_count")
    val totalCount: Int,

    @Json(name = "incomplete_results")
    val incompleteResults: Boolean,

    @Json(name = "items")
    val items: List<Repository>
)