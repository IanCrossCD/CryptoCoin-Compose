package com.crossdevelop.cryptocoincompose.common.domain.usecase

import com.crossdevelop.cryptocoincompose.common.data.repository.CoinRepository
import javax.inject.Inject


class GetCoinDetailUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    suspend fun getCoinDetail(coinId: String) = coinRepository.getCoinDetail(coinId)
}