package com.pavluyk.coin_data.network_service

import com.google.gson.JsonObject
import com.pavluyk.coin_domain.models.CoinModelData
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinMonitoringApi {
    @GET("assets?")
    suspend fun getData(
        @Query("limit") limit: Int = 9,
        @Query("offset") offset: Int? = null
    ): CoinModelData
}