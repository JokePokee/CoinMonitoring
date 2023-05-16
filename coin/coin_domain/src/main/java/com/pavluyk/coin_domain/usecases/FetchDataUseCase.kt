package com.pavluyk.coin_domain.usecases

import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository

class FetchDataUseCase(private val coinMonitoringRepository: CoinMonitoringRepository) {

    suspend fun execute(coinId: Int? = null): List<CoinModel> {
        return coinMonitoringRepository.fetchData(coinId, PAGE_COUNT)
    }

    companion object {
        private const val PAGE_COUNT = 9
    }
}