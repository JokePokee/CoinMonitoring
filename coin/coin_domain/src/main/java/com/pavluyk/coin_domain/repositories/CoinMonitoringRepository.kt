package com.pavluyk.coin_domain.repositories

import com.pavluyk.coin_domain.models.CoinModel
import kotlinx.coroutines.flow.Flow

interface CoinMonitoringRepository {
    suspend fun fetchData(coinId: Int? = null, pageCount: Int)

    suspend fun removeAllCoins()
    fun observeCoinList(): Flow<List<CoinModel>>
}