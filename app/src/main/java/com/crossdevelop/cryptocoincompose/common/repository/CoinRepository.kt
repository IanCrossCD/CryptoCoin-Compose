package com.crossdevelop.cryptocoincompose.common.repository

import com.crossdevelop.cryptocoincompose.common.database.FavoriteCoinDao
import com.crossdevelop.cryptocoincompose.common.database.FavoriteCoinEntity
import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.models.CoinList
import com.crossdevelop.cryptocoincompose.common.network.GeckoApiService
import com.crossdevelop.cryptocoincompose.common.network.responses.CoinListResponse
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CoinRepository @Inject constructor(
    private val favoriteCoinDao: FavoriteCoinDao,
    private val geckoApiService: GeckoApiService
) {

    private var coins: List<CoinListResponse> = emptyList()

    suspend fun getCoinList(): List<CoinList> {
        val favoriteCoinId = getFavoriteCoins()
        if (coins.isEmpty()) {
            coins = geckoApiService.getCoins()
                .filter { it.symbol.lowercase(Locale.getDefault()).isNotBlank() }
                .sortedBy { it.symbol }
        }
        return coins
            .map { it.toCoinList(favoriteCoinId.contains(it.id)) }
            .sortedByDescending { it.favorite }
    }

    private suspend fun getFavoriteCoins(): List<String> {
        return favoriteCoinDao.getFavoriteCoins().map { it.coinId }
    }

    suspend fun getCoinDetail(coinId: String): CoinDetail {
        return geckoApiService.getCoinDetail(coinId = coinId).toCoinDetail()
    }

    suspend fun favoriteCoin(coinId: String) {
        favoriteCoinDao.insertFavoriteCoin(FavoriteCoinEntity(coinId = coinId))
    }

    suspend fun deleteCoin(coinId: String) {
        favoriteCoinDao.insertFavoriteCoin(FavoriteCoinEntity(coinId = coinId))
    }

}