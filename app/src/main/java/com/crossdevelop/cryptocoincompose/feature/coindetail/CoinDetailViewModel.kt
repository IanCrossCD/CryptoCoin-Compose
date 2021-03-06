package com.crossdevelop.cryptocoincompose.feature.coindetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.crossdevelop.cryptocoincompose.common.base.BaseViewModel
import com.crossdevelop.cryptocoincompose.common.di.ActivitySnack
import com.crossdevelop.cryptocoincompose.common.domain.models.CoinDetail
import com.crossdevelop.cryptocoincompose.common.data.repository.CoinRepository
import com.crossdevelop.cryptocoincompose.common.domain.usecase.GetCoinDetailUseCase
import com.crossdevelop.cryptocoincompose.feature.CryptoCoinNavArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    savedState: SavedStateHandle,
    @ActivitySnack private val activitySnack: MutableStateFlow<String?>,
    private val getCoinDetailUseCase: GetCoinDetailUseCase
) : BaseViewModel(activitySnack) {

    private var _coinDetail: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val coinDetail: StateFlow<ViewState> = _coinDetail

    init {
        getCoinDetail(savedState.get<String>(CryptoCoinNavArgs.COIN_ID)!!)
    }

    private fun getCoinDetail(coinId: String) {
        viewModelScope.launch {
            kotlin.runCatching {
                getCoinDetailUseCase.getCoinDetail(coinId)
            }.onSuccess {
                _coinDetail.value = ViewState.CoinDetailResult(it)
            }.onFailure {
                handleError(it)
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class CoinDetailResult(val coinDetail: CoinDetail) : ViewState()
    }
}