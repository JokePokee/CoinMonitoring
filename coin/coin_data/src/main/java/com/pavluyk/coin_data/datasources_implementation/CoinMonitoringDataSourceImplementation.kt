package com.pavluyk.coin_data.datasources_implementation

import com.pavluyk.coin_data.datasources.CoinMonitoringDataSource
import com.pavluyk.coin_data.network_service.CoinMonitoringApi

import com.pavluyk.coin_domain.models.CoinModel

class CoinMonitoringDataSourceImplementation(private val coinMonitoringApi: CoinMonitoringApi) :
    CoinMonitoringDataSource {
    override suspend fun fetchData(coinId: Int?, pageCount: Int): List<CoinModel> {
        return coinMonitoringApi.getData(offset = coinId, limit = pageCount).data
    }

}