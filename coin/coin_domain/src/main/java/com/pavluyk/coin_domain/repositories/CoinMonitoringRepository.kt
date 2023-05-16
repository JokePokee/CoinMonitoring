package com.pavluyk.coin_domain.repositories

import com.pavluyk.coin_domain.models.CoinModel

interface CoinMonitoringRepository {
    suspend fun fetchData(coinId: Int? = null, pageCount: Int): List<CoinModel>
}