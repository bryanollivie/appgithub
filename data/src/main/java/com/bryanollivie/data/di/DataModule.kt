package com.bryanollivie.data.di

import com.bryanollivie.data.remote.source.RemoteDataSource
import com.bryanollivie.data.remote.source.RemoteDataSourceImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<RemoteDataSource> { RemoteDataSourceImpl(serverApi = get()) }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)