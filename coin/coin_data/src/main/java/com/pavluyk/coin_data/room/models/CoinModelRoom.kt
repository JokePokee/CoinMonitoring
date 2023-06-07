package com.pavluyk.coin_data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins")
data class CoinModelRoom(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    @ColumnInfo(name = "symbol")
    var symbol: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "supply")
    var supply: String,
    @ColumnInfo(name = "marketCapUsd")
    var marketCapUsd: Float,
    @ColumnInfo(name = "priceUsd")
    var priceUsd: Float,
    @ColumnInfo(name = "changePercent24Hr")
    var changePercent24Hr: Float,
    @ColumnInfo(name = "vWap24Hr")
    var vWap24Hr: String,
    @ColumnInfo(name = "rank")
    var rank: Int
)