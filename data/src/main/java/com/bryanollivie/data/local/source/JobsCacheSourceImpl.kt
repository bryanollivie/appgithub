package com.bryanollivie.data.local.source

import com.bryanollivie.data.local.database.JobsDao
import com.bryanollivie.data.local.mapper.AndroidJobCacheMapper
import com.bryanollivie.data.local.source.JobsCacheDataSource
import com.bryanollivie.domain.entities.AndroidJob
import io.reactivex.Single

class JobsCacheSourceImpl(private val jobsDao: JobsDao): JobsCacheDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return jobsDao.getJobs()
            .map { AndroidJobCacheMapper.map(it) }
    }

    override fun insertData(list: List<AndroidJob>) {
        jobsDao.insertAll(AndroidJobCacheMapper.mapJobsToCache(list))
    }

    override fun updateData(list: List<AndroidJob>) {
        jobsDao.updateData(AndroidJobCacheMapper.mapJobsToCache(list))
    }
}