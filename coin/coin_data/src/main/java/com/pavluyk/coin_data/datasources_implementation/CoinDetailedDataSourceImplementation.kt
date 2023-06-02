package com.pavluyk.coin_data.datasources_implementation

import com.pavluyk.coin_data.datasources.CoinDetailedDataSource
import com.pavluyk.coin_data.network_service.CoinDetailedApi
import com.pavluyk.coin_domain.models.CoinDetailed

class CoinDetailedDataSourceImplementation(private val coinDetailedApi: CoinDetailedApi) :
    CoinDetailedDataSource {
    override suspend fun fetchDetailedData(id: String): CoinDetailed {
        return coinDetailedApi.getDetailedData(id).data
    }

}