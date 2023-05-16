package com.pavluyk.coin_data.network_service

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinDetailedApi {
    @GET("symbol?")
    suspend fun getDetailedData(
        @Query("asset_symbol") assetSymbol: String
    ): JsonObject
}