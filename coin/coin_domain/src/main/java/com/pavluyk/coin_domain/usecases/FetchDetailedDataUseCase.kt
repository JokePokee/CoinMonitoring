package com.pavluyk.coin_domain.usecases

import com.pavluyk.coin_domain.models.CoinDetailed
import com.pavluyk.coin_domain.repositories.CoinDetailedRepository

class FetchDetailedDataUseCase(private val coinDetailedRepository: CoinDetailedRepository) {
    suspend fun execute(symbol: String? = null): List<CoinDetailed> {
        return coinDetailedRepository.fetchDetailedData(symbol)
    }
}