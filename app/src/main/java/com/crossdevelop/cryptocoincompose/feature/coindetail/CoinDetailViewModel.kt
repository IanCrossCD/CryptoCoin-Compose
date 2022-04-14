package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crossdevelop.cryptocoincompose.common.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.repository.CoinRepository
import com.crossdevelop.cryptocoincompose.feature.CryptoCoinNavArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val savedState: SavedStateHandle,
    private val coinRepository: CoinRepository
) : ViewModel() {

    private var _coinDetail: MutableLiveData<CoinDetail> = MutableLiveData()
    val coinDetail: LiveData<CoinDetail> get() = _coinDetail

    init {
        getCoinDetail(savedState.get<String>(CryptoCoinNavArgs.COIN_ID)!!)
    }

    private fun getCoinDetail(coinId: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                coinRepository.getCoinDetail(coinId)
            }.onSuccess {
                _coinDetail.postValue(it)
            }.onFailure {
                Timber.e(it)
            }
        }
    }
}