package com.bryanollivie.domain.usecases

import com.bryanollivie.domain.entities.AndroidJob
import com.bryanollivie.domain.repository.AndroidJobsRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import java.util.*

class GetJobsUseCases(
    private val repository: AndroidJobsRepository,
    private val scheduler: Scheduler
) {

    fun execute(): Observable<List<AndroidJob>> {
        return repository.getJobs()
            .subscribeOn(scheduler)
    }
}