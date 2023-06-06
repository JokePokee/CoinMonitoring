package com.pavluyk.coin_domain.models

import com.google.gson.annotations.SerializedName

data class CoinModelData(
    @SerializedName("data") val coins: List<CoinModel>
)
