package com.pavluyk.coin_domain.models

import com.google.gson.annotations.SerializedName

data class CoinModel(
    @SerializedName("symbol") var symbol: String,
    @SerializedName("name") var name: String,
    @SerializedName("supply") var supply: String,
    @SerializedName("marketCapUsd") var marketCapUsd: Float,
    @SerializedName("priceUsd") var priceUsd: Float,
    @SerializedName("changePercent24Hr")var changePercent24Hr: Float,
    @SerializedName("vwap24Hr")var vWap24Hr: String,
    @SerializedName("rank")var rank: Int
)
