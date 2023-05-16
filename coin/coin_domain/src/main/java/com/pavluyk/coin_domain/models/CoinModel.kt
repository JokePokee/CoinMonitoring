package com.pavluyk.coin_domain.models

data class CoinModel(
    var symbol: String,
    var name: String,
    var supply: String,
    var marketCapUsd: Float,
    var priceUsd: Float,
    var changePercent24Hr: Float,
    var vWap24Hr: String,
    var rank: Int
)
