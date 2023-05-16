package com.pavluyk.coin_data.repositories

import com.pavluyk.coin_data.datasources.CoinMonitoringDataSource
import com.pavluyk.coin_domain.dispatcher.DefaultDispatcherProvider
import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository
import kotlinx.coroutines.withContext

class CoinMonitoringRepositoryImplementation(private val coinMonitoringDataSource: CoinMonitoringDataSource) :
    CoinMonitoringRepository {
    override suspend fun fetchData(coinId: Int?, pageCount: Int): List<CoinModel> {
        return withContext(DefaultDispatcherProvider.io()) {
            coinMonitoringDataSource.fetchData(coinId, pageCount)
        }
    }
}