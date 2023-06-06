package com.pavluyk.coin_di

import com.pavluyk.coin_data.network_service.CoinMonitoringApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coinMonitoringModule = module {
    single<CoinMonitoringApi> {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        Retrofit.Builder()
            .baseUrl("https://api.coincap.io/v2/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CoinMonitoringApi::class.java)
    }
}
