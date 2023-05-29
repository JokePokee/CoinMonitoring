package com.pavluyk.coin_domain.repositories

import com.pavluyk.coin_domain.models.CoinDetailed

interface CoinDetailedRepository {
    suspend fun fetchDetailedData(symbol: String): CoinDetailed
}