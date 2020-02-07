package com.bryanollivie.domain.repository

import com.bryanollivie.domain.entities.AndroidJob
import io.reactivex.Single

interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>>
}