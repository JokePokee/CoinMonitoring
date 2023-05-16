package com.pavluyk.coin_data.datasources

import com.pavluyk.coin_domain.models.CoinModel

interface CoinMonitoringDataSource {

    suspend fun fetchData(coinId: Int? = null, pageCount: Int): List<CoinModel>
}