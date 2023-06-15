package com.pavluyk.coin_data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pavluyk.coin_data.room.models.CoinModelRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinInfo(coin: List<CoinModelRoom>)

    @Query("SELECT * FROM coins")
    fun observeCoinModels(): Flow<List<CoinModelRoom>>

    @Query("DELETE FROM coins")
    suspend fun removeAllCoins()
}