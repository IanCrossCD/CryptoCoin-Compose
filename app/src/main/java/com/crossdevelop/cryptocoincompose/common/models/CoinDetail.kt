package com.crossdevelop.cryptocoincompose.common.models

import java.time.LocalDate


data class CoinDetail(
    val id: String,
    val symbol: String,
    val name: String,
    val description: String?,
    val links: CoinDetailLinks,
    val image: CoinDetailImage,
    val hashingAlg: String?,
    val blockTimeInMinutes: Int,
    val publicNotice: String?,
    val genesisDate: LocalDate?,
    val currentPrices: CoinDetailCurrentPrice,
    val marketCapRank: Int?
)