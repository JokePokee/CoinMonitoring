package com.pavluyk.coin_domain.usecases

import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository

class FetchCoinUseCase(private val coinMonitoringRepository: CoinMonitoringRepository) {
    suspend fun fetchCoins(coinId: Int? = null) {
        coinMonitoringRepository.fetchData(coinId, FetchCoinUseCase.PAGE_COUNT)
    }

    companion object {
        private const val PAGE_COUNT = 9
    }
}
