package com.bryanollivie.sdk.data.remote

import com.bryanollivie.sdk.data.remote.model.BodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {

    @GET("/search/repositories")
    fun getRepositories(
        @Query("q") q: String = "language:kotlin",
        @Query("sort") list: String = "stars",
        @Query("page") page: String = "1"
    ): Call<BodyResponse>



}