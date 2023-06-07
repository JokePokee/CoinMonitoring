package com.pavluyk.coin_data.room.mapper

import com.pavluyk.coin_data.room.models.CoinModelRoom
import com.pavluyk.coin_domain.models.CoinModel

fun CoinModel.toData(): CoinModelRoom {
    return CoinModelRoom(
        id = null,symbol, name, supply, marketCapUsd, priceUsd, changePercent24Hr, vWap24Hr, rank
    )
}