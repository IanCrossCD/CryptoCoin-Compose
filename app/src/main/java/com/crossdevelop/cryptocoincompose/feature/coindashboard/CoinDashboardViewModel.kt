package com.crossdevelop.cryptocoincompose.feature.coindashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crossdevelop.cryptocoincompose.common.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class CoinDashboardViewModel @Inject constructor(
    private val coinRepository: CoinRepository
) : ViewModel() {

    val coins = coinRepository.coins

    fun refreshCoinList() {
        viewModelScope.launch {
            kotlin.runCatching {
                coinRepository.getCoinList()
            }.onFailure {
                Timber.e(it)
            }
        }
    }

}