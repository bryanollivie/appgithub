package com.bryanollivie.data.remote.mapper

import com.bryanollivie.domain.entities.AndroidJob
import com.bryanollivie.data.remote.model.AndroidJobPayload
import com.bryanollivie.data.remote.model.JobsPayload


object AndroidJobMapper {

    fun map(payload: JobsPayload) = payload.jobsPayload.map { map(it) }

    private fun map(payload: AndroidJobPayload) = AndroidJob(
        title = payload.title,
        experienceTimeRequired = payload.requiredExperienceYears,
        native = payload.native,
        country = payload.country
    )
}