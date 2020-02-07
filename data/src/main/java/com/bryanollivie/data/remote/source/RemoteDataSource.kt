package com.bryanollivie.data.remote.source

import com.bryanollivie.domain.entities.AndroidJob

import io.reactivex.Single

interface RemoteDataSource {
    fun getJobs(): Single<List<AndroidJob>>
}