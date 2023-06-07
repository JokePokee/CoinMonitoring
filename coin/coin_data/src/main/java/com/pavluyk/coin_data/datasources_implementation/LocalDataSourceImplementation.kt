package com.pavluyk.coin_data.datasources_implementation

import com.pavluyk.coin_data.datasources.LocalDataSource
import com.pavluyk.coin_data.room.dao.CoinDao
import com.pavluyk.coin_data.room.mapper.toData
import com.pavluyk.coin_data.room.mapper.toDomain
import com.pavluyk.coin_domain.models.CoinModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataSourceImplementation(
    private val coinDao: CoinDao,
) : LocalDataSource {
    override suspend fun insertCoinModelList(list: List<CoinModel>) {
        coinDao.insertCoinInfo(list.map { it.toData() })
    }

    override fun observeCoinModels(): Flow<List<CoinModel>> {
       return coinDao.observeCoinModels().map { list -> list.map { it.toDomain() } }
    }

    override suspend fun removeAllCoins() {
        coinDao.removeAllCoins()
    }
}