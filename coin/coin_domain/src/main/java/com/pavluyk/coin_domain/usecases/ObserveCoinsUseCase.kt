package com.pavluyk.coin_domain.usecases

import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository
import kotlinx.coroutines.flow.Flow

class ObserveCoinsUseCase(private val coinMonitoringRepository: CoinMonitoringRepository) {
    fun observeCoins(): Flow<List<CoinModel>> {
        return coinMonitoringRepository.observeCoinList()
    }
}