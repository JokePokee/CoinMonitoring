package com.pavluyk.coin_domain.models

import com.google.gson.annotations.SerializedName

data class CoinDetailed(
    @SerializedName("ASSET_DESCRIPTION") val assetDescription: String,
    @SerializedName("LOGO_URL") val logoUrl: String,
    @SerializedName("NAME") val name: String,
)
