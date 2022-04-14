package com.crossdevelop.cryptocoincompose.common.models

import com.squareup.moshi.JsonClass


data class CoinList(
    val id: String,
    val name: String,
    val symbol: String
)