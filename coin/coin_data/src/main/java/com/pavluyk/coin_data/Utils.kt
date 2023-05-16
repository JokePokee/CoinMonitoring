package com.pavluyk.coin_data

import android.util.Log
import com.google.gson.JsonObject
import com.pavluyk.coin_domain.models.CoinDetailed
import com.pavluyk.coin_domain.models.CoinModel

fun JsonObject.toCoinDataList(): List<CoinModel> {
    val firstResponseData = this["data"].asJsonArray

    return firstResponseData.map {
        val data = it.asJsonObject

        val spisok = CoinModel(
            symbol = data["symbol"].asString,
            name = data["name"].asString,
            supply = data["supply"].asString,
            marketCapUsd = data["marketCapUsd"].asFloat,
            priceUsd = data["priceUsd"].asFloat,
            changePercent24Hr = data["changePercent24Hr"].asFloat,
            vWap24Hr = data["vwap24Hr"].toString(),
            rank = data["rank"].asInt
        )
        Log.d("Andrey", "$spisok")
        spisok
    }
}

fun JsonObject.toCoinDetailedList():List<CoinDetailed>{
    return emptyList()
}
