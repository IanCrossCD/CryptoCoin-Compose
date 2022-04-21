package com.crossdevelop.cryptocoincompose.common.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorite_coins")
class FavoriteCoinEntity {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "coin_id")
    var coinId: String = ""

    constructor() {}

    constructor(coinId: String) {
        this.coinId = coinId
    }

}