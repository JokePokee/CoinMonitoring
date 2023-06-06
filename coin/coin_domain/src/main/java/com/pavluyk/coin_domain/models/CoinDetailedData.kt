package com.pavluyk.coin_domain.models

import com.google.gson.annotations.SerializedName

data class CoinDetailedData(
    @SerializedName("Data") val data: CoinDetailed
)
