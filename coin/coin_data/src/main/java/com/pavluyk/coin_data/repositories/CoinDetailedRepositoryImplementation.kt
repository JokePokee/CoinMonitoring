package com.pavluyk.coin_data.repositories

import com.pavluyk.coin_data.datasources.CoinDetailedDataSource
import com.pavluyk.coin_domain.dispatcher.DefaultDispatcherProvider
import com.pavluyk.coin_domain.models.CoinDetailed
import com.pavluyk.coin_domain.repositories.CoinDetailedRepository
import kotlinx.coroutines.withContext

class CoinDetailedRepositoryImplementation(private val coinDetailedDataSource: CoinDetailedDataSource) :
    CoinDetailedRepository {
    override suspend fun fetchDetailedData(id: String): CoinDetailed {
        return withContext(DefaultDispatcherProvider.io()) {
            coinDetailedDataSource.fetchDetailedData(id)
        }
    }
}
