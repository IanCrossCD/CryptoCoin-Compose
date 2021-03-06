package com.crossdevelop.cryptocoincompose.common.data.network.responses

import com.crossdevelop.cryptocoincompose.common.domain.models.CoinList
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CoinListResponse(
    val id: String,
    val name: String,
    val symbol: String
) {

    fun toCoinList(isFavorite : Boolean) = CoinList(id = id, name = name, symbol = symbol, favorite = isFavorite)
}