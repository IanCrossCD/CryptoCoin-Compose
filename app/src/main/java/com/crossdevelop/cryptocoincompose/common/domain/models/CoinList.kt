package com.crossdevelop.cryptocoincompose.common.domain.models


data class CoinList(
    val id: String,
    val name: String,
    val symbol: String,
    val favorite : Boolean
)