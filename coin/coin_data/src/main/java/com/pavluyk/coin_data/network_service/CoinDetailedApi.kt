package com.pavluyk.coin_data.network_service

import com.google.gson.JsonObject
import com.pavluyk.coin_domain.models.CoinDetailedData
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinDetailedApi {
    @GET("symbol?")
    suspend fun getDetailedData(
        @Query("asset_symbol") assetSymbol: String? = null
    ): CoinDetailedData
}