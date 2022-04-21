package com.crossdevelop.cryptocoincompose.common.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorite_coins")
class FavoriteCoinEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0

    @ColumnInfo(name = "coin_id")
    var coinId: String = ""

    constructor() {}

    constructor(id: Int, coinId: String) {
        this.id = id
        this.coinId = coinId
    }

    constructor(coinId: String) {
        this.coinId = coinId
    }

}