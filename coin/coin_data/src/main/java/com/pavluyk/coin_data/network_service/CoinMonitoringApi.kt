package com.pavluyk.coin_data.network_service

import com.google.gson.JsonObject
import retrofit2.http.GET

interface CoinMonitoringApi {

    @GET("assets?limit=9")
    suspend fun getData(): JsonObject
}