package com.pavluyk.coin_data.datasources

import com.pavluyk.coin_domain.models.CoinDetailed

interface CoinDetailedDataSource {
    suspend fun fetchDetailedData(symbol: String): List<CoinDetailed>
}