package com.crossdevelop.cryptocoincompose.common.domain.usecase

import com.crossdevelop.cryptocoincompose.common.data.repository.CoinRepository
import javax.inject.Inject


class FavoriteCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    suspend fun favoriteCoin(coinId: String) = coinRepository.favoriteCoin(coinId = coinId)

}