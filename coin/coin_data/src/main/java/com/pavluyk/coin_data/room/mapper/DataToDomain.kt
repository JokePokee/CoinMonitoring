package com.pavluyk.coin_data.room.mapper

import com.pavluyk.coin_data.room.models.CoinModelRoom
import com.pavluyk.coin_domain.models.CoinModel

fun CoinModelRoom.toDomain(): CoinModel {
    return CoinModel(
        symbol,
        name,
        supply,
        marketCapUsd,
        priceUsd,
        changePercent24Hr,
        vWap24Hr,
        rank
    )
}