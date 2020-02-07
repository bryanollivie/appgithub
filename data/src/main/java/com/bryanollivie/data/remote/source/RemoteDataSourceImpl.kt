package com.bryanollivie.data.remote.source

import com.bryanollivie.data.remote.api.ServerApi
import com.bryanollivie.data.remote.mapper.AndroidJobMapper
import com.bryanollivie.data.remote.source.RemoteDataSource
import com.bryanollivie.domain.entities.AndroidJob
import io.reactivex.Single

class RemoteDataSourceImpl(private val serverApi: ServerApi):
    RemoteDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return serverApi.fetchJobs()
            .map { AndroidJobMapper.map(it) }
    }
}