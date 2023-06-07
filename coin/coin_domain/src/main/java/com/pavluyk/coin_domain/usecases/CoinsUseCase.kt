package com.pavluyk.coin_domain.usecases

import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository
import kotlinx.coroutines.flow.Flow

class CoinsUseCase(private val coinMonitoringRepository: CoinMonitoringRepository) {

    suspend fun fetchCoins(coinId: Int? = null) {
        coinMonitoringRepository.fetchData(coinId, PAGE_COUNT)
    }

    suspend fun removeAllCoins() {
        coinMonitoringRepository.removeAllCoins()
    }

    fun observeCoins(): Flow<List<CoinModel>> {
        return coinMonitoringRepository.observeCoinList()
    }

    companion object {
        private const val PAGE_COUNT = 9
    }
}