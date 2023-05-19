package com.pavluyk.coin_di

import com.pavluyk.coin_data.datasources.CoinDetailedDataSource
import com.pavluyk.coin_data.datasources.CoinMonitoringDataSource
import com.pavluyk.coin_data.datasources_implementation.CoinDetailedDataSourceImplementation
import com.pavluyk.coin_data.datasources_implementation.CoinMonitoringDataSourceImplementation
import com.pavluyk.coin_data.repositories.CoinDetailedRepositoryImplementation
import com.pavluyk.coin_data.repositories.CoinMonitoringRepositoryImplementation
import com.pavluyk.coin_domain.repositories.CoinDetailedRepository
import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository
import com.pavluyk.coin_domain.usecases.FetchDataUseCase
import com.pavluyk.coin_domain.usecases.FetchDetailedDataUseCase
import org.koin.dsl.module

val appModule = module {
    factory { FetchDataUseCase(get()) }
    factory { FetchDetailedDataUseCase(get()) }

    factory<CoinMonitoringRepository> { CoinMonitoringRepositoryImplementation(get()) }
    factory<CoinDetailedRepository> { CoinDetailedRepositoryImplementation(get()) }

    single<CoinMonitoringDataSource> { CoinMonitoringDataSourceImplementation(get()) }
    single<CoinDetailedDataSource> { CoinDetailedDataSourceImplementation(get()) }

}