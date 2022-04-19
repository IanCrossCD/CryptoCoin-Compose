package com.crossdevelop.cryptocoincompose.common.network

import com.crossdevelop.cryptocoincompose.common.network.responses.CoinDetailResponse
import com.crossdevelop.cryptocoincompose.common.network.responses.CoinListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GeckoApiService {

    @GET("coins/list")
    suspend fun getCoins(): List<CoinListResponse>

    @GET("coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId: String) : CoinDetailResponse

}

