package com.pavluyk.coin_data.repositories

import com.pavluyk.coin_data.datasources.CoinMonitoringDataSource
import com.pavluyk.coin_data.datasources.LocalDataSource
import com.pavluyk.coin_domain.dispatcher.DefaultDispatcherProvider
import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CoinMonitoringRepositoryImplementation(
    private val coinMonitoringDataSource: CoinMonitoringDataSource,
    private val localDataSource: LocalDataSource
) :
    CoinMonitoringRepository {
    override suspend fun fetchData(coinId: Int?, pageCount: Int) {
        return withContext(DefaultDispatcherProvider.io()) {
            coinMonitoringDataSource.fetchData(coinId, pageCount)
                .also { localDataSource.insertCoinModelList(it) }
        }
    }

    override suspend fun removeAllCoins() {
        withContext(DefaultDispatcherProvider.io()) {
            localDataSource.removeAllCoins()
        }
    }

    override fun observeCoinList(): Flow<List<CoinModel>> {
        return localDataSource.observeCoinModels()
    }
}