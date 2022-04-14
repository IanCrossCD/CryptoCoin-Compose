package com.crossdevelop.cryptocoincompose.common.network

import com.crossdevelop.cryptocoincompose.common.network.responses.CoinListResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface GeckoApiService {


    @GET("coins/list")
    suspend fun getCoins(): List<CoinListResponse>

}

