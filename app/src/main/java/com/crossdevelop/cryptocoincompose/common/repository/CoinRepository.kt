package com.crossdevelop.cryptocoincompose.common.repository

import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.network.GeckoApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CoinRepository @Inject constructor(
    private val geckoApiService: GeckoApiService
) {

    suspend fun getCoinList(): List<CoinList> {
        return geckoApiService.getCoins().map { it.toCoinList() }
    }

    suspend fun getCoinDetail(coinId: String): CoinDetail {
        return geckoApiService.getCoinDetail(coinId = coinId).toCoinDetail()
    }

}