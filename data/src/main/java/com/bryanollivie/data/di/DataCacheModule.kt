package com.bryanollivie.data.di

import com.bryanollivie.data.local.database.DataBase
import com.bryanollivie.data.local.source.JobsCacheDataSource
import com.bryanollivie.data.local.source.JobsCacheSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module {
    single { DataBase.createDataBase(androidContext()) }
    factory<JobsCacheDataSource> { JobsCacheSourceImpl(jobsDao = get()) }
}