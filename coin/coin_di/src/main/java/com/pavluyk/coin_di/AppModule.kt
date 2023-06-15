package com.pavluyk.coin_di

import com.pavluyk.coin_data.datasources.CoinDetailedDataSource
import com.pavluyk.coin_data.datasources.CoinMonitoringDataSource
import com.pavluyk.coin_data.datasources.LocalDataSource
import com.pavluyk.coin_data.datasources_implementation.CoinDetailedDataSourceImplementation
import com.pavluyk.coin_data.datasources_implementation.CoinMonitoringDataSourceImplementation
import com.pavluyk.coin_data.datasources_implementation.LocalDataSourceImplementation
import com.pavluyk.coin_data.repositories.CoinDetailedRepositoryImplementation
import com.pavluyk.coin_data.repositories.CoinMonitoringRepositoryImplementation
import com.pavluyk.coin_data.room.AppDataBase
import com.pavluyk.coin_domain.repositories.CoinDetailedRepository
import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository
import com.pavluyk.coin_domain.usecases.FetchCoinUseCase
import com.pavluyk.coin_domain.usecases.FetchDetailedDataUseCase
import com.pavluyk.coin_domain.usecases.ObserveCoinsUseCase
import com.pavluyk.coin_domain.usecases.RemoveCoinsUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { FetchCoinUseCase(coinMonitoringRepository = get()) }
    factory { ObserveCoinsUseCase(coinMonitoringRepository = get()) }
    factory { RemoveCoinsUseCase(coinMonitoringRepository = get()) }
    factory { FetchDetailedDataUseCase(coinDetailedRepository = get()) }

    factory<CoinMonitoringRepository> {
        CoinMonitoringRepositoryImplementation(
            coinMonitoringDataSource = get(),
            localDataSource = get()
        )
    }
    factory<CoinDetailedRepository> { CoinDetailedRepositoryImplementation(coinDetailedDataSource = get()) }

    single<LocalDataSource> {
        LocalDataSourceImplementation(
            coinDao = AppDataBase.getInstance(
                androidContext()
            ).coinDao
        )
    }
    single<CoinMonitoringDataSource> { CoinMonitoringDataSourceImplementation(coinMonitoringApi = get()) }
    single<CoinDetailedDataSource> { CoinDetailedDataSourceImplementation(coinDetailedApi = get()) }
}