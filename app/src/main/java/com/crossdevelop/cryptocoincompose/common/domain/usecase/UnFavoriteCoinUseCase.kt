package com.crossdevelop.cryptocoincompose.common.domain.usecase

import com.crossdevelop.cryptocoincompose.common.data.repository.CoinRepository
import javax.inject.Inject


class UnFavoriteCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    suspend fun unFavoriteCoin(coinId: String) = coinRepository.deleteCoin(coinId = coinId)
}