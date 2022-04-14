package com.crossdevelop.cryptocoincompose.common.network.responses

import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
import com.squareup.moshi.Json


data class CoinDetailResponse(
    val symbol: String,
    val name: String,
    @Json(name = "hashing_algorithm") val hashingAlg : String) {

    fun toCoinDetail() = CoinDetail(symbol, name, hashingAlg)
}