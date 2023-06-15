package com.pavluyk.coin_domain.usecases

import com.pavluyk.coin_domain.repositories.CoinMonitoringRepository

class RemoveCoinsUseCase(private val coinMonitoringRepository: CoinMonitoringRepository) {
    suspend fun removeAllCoins() {
        coinMonitoringRepository.removeAllCoins()
    }
}