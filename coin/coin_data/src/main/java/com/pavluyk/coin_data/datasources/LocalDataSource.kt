package com.pavluyk.coin_data.datasources


import com.pavluyk.coin_domain.models.CoinModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun saveCoins(list: List<CoinModel>)

    fun observeCoins(): Flow<List<CoinModel>>

    suspend fun removeAllCoins()
}