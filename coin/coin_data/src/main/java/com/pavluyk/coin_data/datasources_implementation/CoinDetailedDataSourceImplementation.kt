package com.pavluyk.coin_data.datasources_implementation

import com.pavluyk.coin_data.datasources.CoinDetailedDataSource
import com.pavluyk.coin_data.network_service.CoinDetailedApi
import com.pavluyk.coin_data.toCoinDataList
import com.pavluyk.coin_data.toCoinDetailedList
import com.pavluyk.coin_domain.models.CoinDetailed

class CoinDetailedDataSourceImplementation(private val coinDetailedApi: CoinDetailedApi) :
    CoinDetailedDataSource {
    override suspend fun fetchDetailedData(symbol: String): List<CoinDetailed> {
        return coinDetailedApi.getDetailedData(symbol).toCoinDetailedList()
    }

}