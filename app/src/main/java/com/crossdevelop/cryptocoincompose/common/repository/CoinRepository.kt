package com.crossdevelop.cryptocoincompose.common.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.network.GeckoApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CoinRepository @Inject constructor(
    private val geckoApiService: GeckoApiService
) {

    private var _coins = MutableLiveData<List<CoinList>>()
    val coins: LiveData<List<CoinList>> get() = _coins

    suspend fun getCoinList() {
        _coins.value = geckoApiService.getCoins().map { it.toCoinList() }
    }

}